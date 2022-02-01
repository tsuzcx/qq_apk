package com.tencent.mobileqq.activity.richmedia.p2veffect.music;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.download.DownloadProgressListener;
import com.tencent.biz.qqstory.base.download.DownloaderImp;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.AddressDataProvider;
import com.tencent.biz.qqstory.model.AddressDataProvider.AddressInfo;
import com.tencent.biz.qqstory.model.DataProvider.DataUpdateListener;
import com.tencent.biz.qqstory.model.DataProviderManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MusicConfigInfo;
import com.tencent.biz.qqstory.network.request.GetMusicConfigRequest;
import com.tencent.biz.qqstory.network.response.GetMusicConfigResponse;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicCache;
import com.tencent.biz.qqstory.takevideo.music.MusicGridAdapter;
import com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView;
import com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView.SeekListener;
import com.tencent.biz.qqstory.takevideo.music.QQStoryBGMusicUtils;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

@TargetApi(11)
public class P2VEditMusicDialog
  extends Dialog
  implements View.OnClickListener, AdapterView.OnItemClickListener, DownloadProgressListener, CmdTaskManger.CommandCallback<GetMusicConfigRequest, GetMusicConfigResponse>, MusicHorizontalSeekView.SeekListener
{
  private static final String jdField_a_of_type_JavaLangString = P2VEditMusicDialog.class.getSimpleName();
  protected int a;
  protected long a;
  protected Handler a;
  protected View a;
  protected GridView a;
  protected ProgressBar a;
  protected TextView a;
  protected DownloaderImp a;
  private DataProvider.DataUpdateListener<AddressDataProvider.AddressInfo> jdField_a_of_type_ComTencentBizQqstoryModelDataProvider$DataUpdateListener = new P2VEditMusicDialog.4(this);
  private EditVideoMusicCache jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicCache;
  protected MusicGridAdapter a;
  protected MusicHorizontalSeekView a;
  protected QQStoryMusicInfo a;
  public P2VEditMusicDialog.IP2VMusicEditListener a;
  protected P2VEditMusicDialog.MusicPlayTask a;
  ArrayList<QQStoryMusicInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected HashMap<String, String> a;
  protected Timer a;
  protected boolean a;
  protected int b;
  protected long b;
  protected View b;
  protected TextView b;
  protected HashMap<String, Long> b;
  protected int c;
  protected View c;
  protected TextView c;
  protected volatile int d;
  protected TextView d;
  protected TextView e = null;
  protected TextView f = null;
  
  public P2VEditMusicDialog(Context paramContext, P2VEditMusicDialog.IP2VMusicEditListener paramIP2VMusicEditListener, int paramInt, boolean paramBoolean)
  {
    super(paramContext, 2131755168);
    this.jdField_a_of_type_AndroidWidgetGridView = null;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter = null;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_c_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp = null;
    this.jdField_a_of_type_JavaUtilTimer = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask = null;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new P2VEditMusicDialog.2(this);
    this.jdField_d_of_type_Int = 0;
    super.requestWindowFeature(1);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener = paramIP2VMusicEditListener;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicCache = new EditVideoMusicCache(paramContext, new P2VEditMusicDialog.1(this), this.jdField_a_of_type_AndroidOsHandler);
    a(paramContext);
    paramContext = super.getWindow().getAttributes();
    paramContext.width = -1;
    paramContext.height = -1;
    paramContext.windowAnimations = 2131755186;
    super.getWindow().setBackgroundDrawable(new ColorDrawable());
  }
  
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { DeviceInfoUtil.a(), "", Integer.valueOf(5) }));
    localIntent.putExtra("finish_animation_up_down", true);
    paramActivity.startActivityForResult(localIntent, 1000);
    paramActivity.overridePendingTransition(2130771981, 0);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_b_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.g))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a(QQStoryMusicInfo.jdField_b_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a(QQStoryMusicInfo.jdField_b_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
  }
  
  private void h()
  {
    QQStoryMusicInfo localQQStoryMusicInfo = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a();
    if ((localQQStoryMusicInfo == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo == null) || ((localQQStoryMusicInfo.jdField_b_of_type_Int != 3) && (localQQStoryMusicInfo.jdField_b_of_type_Int != 2))) {}
    for (;;)
    {
      dismiss();
      return;
      if (localQQStoryMusicInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_a_of_type_JavaLangString)) {}
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.d();
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_Int < 5000) {
      return 5000;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    f();
    d();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = (int)(this.jdField_c_of_type_AndroidWidgetTextView.getPaint().measureText("00:00") / 2.0F);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt1 - i);
    this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    localLayoutParams = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt2 - i * 2);
    this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    b();
    b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(Context paramContext)
  {
    Object localObject = LayoutInflater.from(paramContext).inflate(2131561867, null);
    super.setContentView((View)localObject);
    boolean bool;
    if (this.jdField_a_of_type_Int < 5000)
    {
      this.jdField_a_of_type_Long = (this.jdField_a_of_type_Int / 6);
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject).findViewById(2131372022));
      this.jdField_b_of_type_AndroidViewView = ((View)localObject).findViewById(2131372005);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView = ((MusicHorizontalSeekView)((View)localObject).findViewById(2131372007));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setOnSeekListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131372008));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377692));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377691));
      this.e = ((TextView)super.findViewById(2131372017));
      this.f = ((TextView)super.findViewById(2131372018));
      this.e.setOnClickListener(this);
      this.f.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366317));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131377742);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.b()) {
        break label459;
      }
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)((View)localObject).findViewById(2131372006));
      this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(-1);
      this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
      }
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this);
      this.jdField_c_of_type_AndroidViewView = ((View)localObject).findViewById(2131365905);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      localObject = this.jdField_a_of_type_AndroidWidgetGridView;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.c()) {
        break label454;
      }
      bool = true;
      label317:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter = new MusicGridAdapter(paramContext, (GridView)localObject, bool, true);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(null);
      label351:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a() == null) {
        break label497;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = new QQStoryMusicInfo();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = QQStoryMusicInfo.a(getContext());
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      if (!NetworkUtil.d(getContext())) {
        break label513;
      }
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      paramContext = new GetMusicConfigRequest();
      CmdTaskManger.a().a(paramContext, this);
      return;
      this.jdField_a_of_type_Long = 1000L;
      break;
      label454:
      bool = false;
      break label317;
      label459:
      ((View)localObject).findViewById(2131365824).getLayoutParams().height = AIOUtils.a(138.0F, paramContext.getResources());
      ((View)localObject).findViewById(2131372009).setVisibility(8);
      break label351;
      label497:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a();
    }
    label513:
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    QQToast.a(getContext(), HardCodeUtil.a(2131707845), 0).a();
  }
  
  public void a(GetMusicConfigRequest paramGetMusicConfigRequest, GetMusicConfigResponse paramGetMusicConfigResponse, ErrorMessage paramErrorMessage)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("onCmdRespond = ").append(System.currentTimeMillis() - this.jdField_b_of_type_Long).append(", errorMsg = ");
      if (paramErrorMessage != null) {
        break label203;
      }
    }
    label203:
    for (paramGetMusicConfigRequest = "null";; paramGetMusicConfigRequest = paramErrorMessage.getErrorMessage())
    {
      QLog.d(str, 2, paramGetMusicConfigRequest);
      StoryReportor.a("edit_video", "music_list_time", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long), "", "", "" });
      if ((paramErrorMessage == null) || (!paramErrorMessage.isFail())) {
        break;
      }
      paramGetMusicConfigRequest = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
      paramGetMusicConfigRequest.obj = ("onCmdRespond error = " + paramErrorMessage.getErrorMessage());
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramGetMusicConfigRequest);
      StoryReportor.a("edit_video", "music_list_failed", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    paramGetMusicConfigResponse = paramGetMusicConfigResponse.a;
    int j = paramGetMusicConfigResponse.music_config.size();
    paramGetMusicConfigRequest = new ArrayList(j);
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        paramGetMusicConfigRequest.add(new QQStoryMusicInfo((qqstory_struct.MusicConfigInfo)paramGetMusicConfigResponse.music_config.get(i)));
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramGetMusicConfigResponse = new StringBuffer();
        paramGetMusicConfigResponse.append("GetMusicConfigResponse size = " + j);
        i = 0;
        while (i < j)
        {
          paramErrorMessage = (QQStoryMusicInfo)paramGetMusicConfigRequest.get(i);
          paramGetMusicConfigResponse.append(", " + i + ": title = " + paramErrorMessage.jdField_b_of_type_JavaLangString + ", audioUrl = " + paramErrorMessage.jdField_d_of_type_JavaLangString);
          i += 1;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, paramGetMusicConfigResponse.toString());
      }
    }
    for (;;)
    {
      StoryReportor.a("edit_video", "music_list_count", 0, 0, new String[] { String.valueOf(j), "", "", "" });
      this.jdField_a_of_type_JavaUtilArrayList = paramGetMusicConfigRequest;
      QQStoryMusicInfo.a(getContext(), paramGetMusicConfigRequest);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onCmdRespond data is NULL!!!!!");
      }
    }
  }
  
  protected void a(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    String str2 = paramQQStoryMusicInfo.jdField_d_of_type_JavaLangString;
    String str1 = paramQQStoryMusicInfo.g;
    if ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str1)))
    {
      paramQQStoryMusicInfo = str1;
      if (!com.tencent.biz.qqstory.utils.FileUtils.e(str1))
      {
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2);
        paramQQStoryMusicInfo = str1;
        if (!com.tencent.biz.qqstory.utils.FileUtils.e(str1)) {
          paramQQStoryMusicInfo = QQStoryBGMusicUtils.a(str2);
        }
      }
      if (com.tencent.biz.qqstory.utils.FileUtils.e(paramQQStoryMusicInfo))
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a()))
        {
          com.tencent.mobileqq.utils.FileUtils.e(this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a());
          this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a() != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a(paramQQStoryMusicInfo);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        }
        for (;;)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "exists audio_url = " + str2 + ", path = " + paramQQStoryMusicInfo);
          return;
          QLog.e(jdField_a_of_type_JavaLangString, 1, "getCurFragmentMusic - urMusic is null");
        }
      }
      if (!NetworkUtil.g(BaseApplication.getContext()))
      {
        f();
        QQToast.a(BaseApplication.getContext(), 2131695222, 0).a();
        return;
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(str2, Long.valueOf(System.currentTimeMillis()));
      this.jdField_a_of_type_JavaUtilHashMap.put(str2, paramQQStoryMusicInfo);
      if ((this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a()))
      {
        com.tencent.mobileqq.utils.FileUtils.e(this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a());
        this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a();
      }
      ThreadManager.post(new P2VEditMusicDialog.3(this, str2), 5, null, true);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "playCacheMusicOrDownload - musicUrl、localPath both null ？！");
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = QQStoryBGMusicUtils.a(paramString);
    if (paramInt == 0)
    {
      this.jdField_d_of_type_Int = 0;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onDownloadFinish() url = " + paramString);
      }
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, str);
      QQStoryMusicInfo localQQStoryMusicInfo = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a();
      if ((localQQStoryMusicInfo != null) && (paramString.equals(localQQStoryMusicInfo.jdField_d_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a(str);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        getContext().getSharedPreferences("VideoMusicCache", 0).edit().putString(localQQStoryMusicInfo.jdField_a_of_type_JavaLangString, str).apply();
      }
      StoryReportor.a("edit_video", "music_download_success", 0, 0, new String[] { "", "", "", "" });
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        long l = ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).longValue();
        paramString = new StringBuffer("onDownloadFinish errCode = ").append(paramInt).append(", name = ").append(com.tencent.biz.qqstory.utils.FileUtils.b(paramString)).append(", downloadTime = ").append(System.currentTimeMillis() - l).append(", fileSize = ").append(com.tencent.biz.qqstory.utils.FileUtils.a(str)).append(", url = " + paramString);
        QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.toString());
      }
      return;
      StoryReportor.a("edit_video", "music_download_failed", 0, 0, new String[] { String.valueOf(paramInt), "", "", "" });
      VideoEditReport.a("0X80076D9");
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    float f1 = (float)paramLong1 / (float)paramLong2;
    if (f1 >= this.jdField_d_of_type_Int * 0.05F)
    {
      this.jdField_d_of_type_Int += 1;
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
      paramString.arg1 = ((int)(100.0F * f1));
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onProgress() mIndex = " + this.jdField_d_of_type_Int + ", progress = " + f1 + ", cur = " + paramLong1 + ", size = " + paramLong2);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDownloadStart() url = " + paramString1 + ", dstPath = " + paramString2);
    }
    this.jdField_d_of_type_Int = 0;
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
    paramString1.arg1 = 0;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
  }
  
  protected void b()
  {
    e();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.b();
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    int i = 1000;
    int j = (paramInt2 - paramInt1) / 1000 * 1000;
    if (j < 1000) {}
    for (;;)
    {
      j = i;
      if (this.jdField_c_of_type_Int == 1)
      {
        j = i;
        if (i > 8500.0D)
        {
          j = i;
          if (i < 13500.0D) {
            j = 10000;
          }
        }
      }
      i = j + paramInt1;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "start = " + paramInt1 + ", end = " + paramInt2 + ", displayEnd = " + i);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(QQStoryBGMusicUtils.a(paramInt1, false));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(QQStoryBGMusicUtils.a(i, true));
      return;
      i = j;
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    QQStoryMusicInfo localQQStoryMusicInfo = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a();
    if (localQQStoryMusicInfo != null)
    {
      localQQStoryMusicInfo.jdField_d_of_type_Int = ((int)(localQQStoryMusicInfo.f * (paramInt3 / paramInt1)));
      localQQStoryMusicInfo.e = (localQQStoryMusicInfo.jdField_d_of_type_Int + this.jdField_a_of_type_Int);
      b(localQQStoryMusicInfo.jdField_d_of_type_Int, localQQStoryMusicInfo.e);
    }
  }
  
  public void b(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    if ((!TextUtils.isEmpty(paramQQStoryMusicInfo.jdField_d_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramQQStoryMusicInfo.g)))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramQQStoryMusicInfo.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a(paramQQStoryMusicInfo);
    a(paramQQStoryMusicInfo);
    VideoEditReport.a("0X80076D6");
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.c();
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, paramInt3);
    c();
  }
  
  public void d()
  {
    e();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask = new P2VEditMusicDialog.MusicPlayTask(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask, 0L, this.jdField_a_of_type_Long);
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicCache.a();
    if ((this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a()))
    {
      com.tencent.mobileqq.utils.FileUtils.e(this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a());
      this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a();
    }
    ((AddressDataProvider)((DataProviderManager)SuperManager.a(20)).a(1)).b(this.jdField_a_of_type_ComTencentBizQqstoryModelDataProvider$DataUpdateListener);
    e();
    c();
    super.dismiss();
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask.cancel();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask = null;
    }
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
  }
  
  protected void f()
  {
    QQStoryMusicInfo localQQStoryMusicInfo = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a();
    if ((localQQStoryMusicInfo != null) && (localQQStoryMusicInfo.jdField_b_of_type_Int == 3) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(localQQStoryMusicInfo) > 0) && (!localQQStoryMusicInfo.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a())))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(localQQStoryMusicInfo);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkButtonState 按钮错位!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      }
    }
  }
  
  public void onBackPressed()
  {
    g();
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      g();
      dismiss();
      continue;
      h();
      continue;
      h();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QQStoryMusicInfo localQQStoryMusicInfo;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter != null)
    {
      localQQStoryMusicInfo = (QQStoryMusicInfo)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.getItem(paramInt);
      if (localQQStoryMusicInfo != null) {
        break label70;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onItemClick error musicInfo = " + null);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label70:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(localQQStoryMusicInfo);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.notifyDataSetChanged();
      if (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a())
      {
        b();
        if (localQQStoryMusicInfo.jdField_b_of_type_Int == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a(localQQStoryMusicInfo);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        }
        else if (localQQStoryMusicInfo.jdField_b_of_type_Int == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a(localQQStoryMusicInfo);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        }
        else if (localQQStoryMusicInfo.jdField_b_of_type_Int == 2)
        {
          if (!NetworkUtil.g(BaseApplication.getContext()))
          {
            f();
            QQToast.a(BaseApplication.getContext(), 2131695222, 0).a();
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a();
            if ((!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a()) && ((getContext() instanceof ContextThemeWrapper)) && ((((ContextThemeWrapper)getContext()).getBaseContext() instanceof Activity))) {
              a((Activity)((ContextThemeWrapper)getContext()).getBaseContext());
            }
          }
        }
      }
      else
      {
        b();
        if (!TextUtils.isEmpty(localQQStoryMusicInfo.jdField_d_of_type_JavaLangString))
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(localQQStoryMusicInfo.jdField_b_of_type_JavaLangString);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a(localQQStoryMusicInfo);
        a(localQQStoryMusicInfo);
        StoryReportor.a("video_edit", "add_music", 0, 0, new String[] { "1", "", "", "" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog
 * JD-Core Version:    0.7.0.1
 */