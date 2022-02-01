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
import com.tencent.mobileqq.utils.TimeFormatterUtils;
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
  private static final String jdField_a_of_type_JavaLangString = "P2VEditMusicDialog";
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
    super(paramContext, 2131755332);
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
    paramContext.windowAnimations = 2131755350;
    super.getWindow().setBackgroundDrawable(new ColorDrawable());
  }
  
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { DeviceInfoUtil.a(), "", Integer.valueOf(5) }));
    localIntent.putExtra("finish_animation_up_down", true);
    paramActivity.startActivityForResult(localIntent, 1000);
    paramActivity.overridePendingTransition(2130771993, 0);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
    QQStoryMusicInfo localQQStoryMusicInfo = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
    if (localQQStoryMusicInfo != null)
    {
      if (localQQStoryMusicInfo.jdField_b_of_type_Int == 1)
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
    if ((localQQStoryMusicInfo != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo != null) && ((localQQStoryMusicInfo.jdField_b_of_type_Int == 3) || (localQQStoryMusicInfo.jdField_b_of_type_Int == 2))) {
      localQQStoryMusicInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_a_of_type_JavaLangString);
    }
    dismiss();
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.d();
  }
  
  protected int a()
  {
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (j < 5000) {
      i = 5000;
    }
    return i;
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
    View localView = LayoutInflater.from(paramContext).inflate(2131561718, null);
    super.setContentView(localView);
    int i = this.jdField_a_of_type_Int;
    if (i < 5000) {
      this.jdField_a_of_type_Long = (i / 6);
    } else {
      this.jdField_a_of_type_Long = 1000L;
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131371623));
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131371612);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView = ((MusicHorizontalSeekView)localView.findViewById(2131371614));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setOnSeekListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371615));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377128));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377127));
    this.e = ((TextView)super.findViewById(2131371619));
    this.f = ((TextView)super.findViewById(2131371620));
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131366205));
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131377170);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.b())
    {
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131371613));
      this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(-1);
      this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
      }
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this);
      this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131365743);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter = new MusicGridAdapter(paramContext, this.jdField_a_of_type_AndroidWidgetGridView, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.c() ^ true, true);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(null);
    }
    else
    {
      localView.findViewById(2131365661).getLayoutParams().height = AIOUtils.b(138.0F, paramContext.getResources());
      localView.findViewById(2131371616).setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a() != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = new QQStoryMusicInfo();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a());
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a();
    }
    this.jdField_a_of_type_JavaUtilArrayList = QQStoryMusicInfo.a(getContext());
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    if (NetworkUtil.isNetSupport(getContext()))
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      paramContext = new GetMusicConfigRequest();
      CmdTaskManger.a().a(paramContext, this);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    QQToast.a(getContext(), HardCodeUtil.a(2131707868), 0).a();
  }
  
  public void a(GetMusicConfigRequest paramGetMusicConfigRequest, GetMusicConfigResponse paramGetMusicConfigResponse, ErrorMessage paramErrorMessage)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCmdRespond = ");
      localStringBuilder.append(System.currentTimeMillis() - this.jdField_b_of_type_Long);
      localStringBuilder.append(", errorMsg = ");
      if (paramErrorMessage == null) {
        paramGetMusicConfigRequest = "null";
      } else {
        paramGetMusicConfigRequest = paramErrorMessage.getErrorMessage();
      }
      localStringBuilder.append(paramGetMusicConfigRequest);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    StoryReportor.a("edit_video", "music_list_time", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long), "", "", "" });
    if ((paramErrorMessage != null) && (paramErrorMessage.isFail()))
    {
      paramGetMusicConfigRequest = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
      paramGetMusicConfigResponse = new StringBuilder();
      paramGetMusicConfigResponse.append("onCmdRespond error = ");
      paramGetMusicConfigResponse.append(paramErrorMessage.getErrorMessage());
      paramGetMusicConfigRequest.obj = paramGetMusicConfigResponse.toString();
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
        paramErrorMessage = new StringBuilder();
        paramErrorMessage.append("GetMusicConfigResponse size = ");
        paramErrorMessage.append(j);
        paramGetMusicConfigResponse.append(paramErrorMessage.toString());
        i = 0;
        while (i < j)
        {
          paramErrorMessage = (QQStoryMusicInfo)paramGetMusicConfigRequest.get(i);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(": title = ");
          ((StringBuilder)localObject).append(paramErrorMessage.jdField_b_of_type_JavaLangString);
          ((StringBuilder)localObject).append(", audioUrl = ");
          ((StringBuilder)localObject).append(paramErrorMessage.jdField_d_of_type_JavaLangString);
          paramGetMusicConfigResponse.append(((StringBuilder)localObject).toString());
          i += 1;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, paramGetMusicConfigResponse.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onCmdRespond data is NULL!!!!!");
    }
    StoryReportor.a("edit_video", "music_list_count", 0, 0, new String[] { String.valueOf(j), "", "", "" });
    this.jdField_a_of_type_JavaUtilArrayList = paramGetMusicConfigRequest;
    QQStoryMusicInfo.a(getContext(), paramGetMusicConfigRequest);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  protected void a(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    String str = paramQQStoryMusicInfo.jdField_d_of_type_JavaLangString;
    Object localObject = paramQQStoryMusicInfo.g;
    if ((TextUtils.isEmpty(str)) && (TextUtils.isEmpty((CharSequence)localObject)))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "playCacheMusicOrDownload - musicUrl、localPath both null ？！");
      return;
    }
    paramQQStoryMusicInfo = (QQStoryMusicInfo)localObject;
    if (!com.tencent.biz.qqstory.utils.FileUtils.e((String)localObject))
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str);
      paramQQStoryMusicInfo = (QQStoryMusicInfo)localObject;
      if (!com.tencent.biz.qqstory.utils.FileUtils.e((String)localObject)) {
        paramQQStoryMusicInfo = QQStoryBGMusicUtils.a(str);
      }
    }
    if (com.tencent.biz.qqstory.utils.FileUtils.e(paramQQStoryMusicInfo))
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp;
      if ((localObject != null) && (((DownloaderImp)localObject).a()))
      {
        com.tencent.mobileqq.utils.FileUtils.deleteFile(this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a());
        this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a() != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a(paramQQStoryMusicInfo);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
      else
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "getCurFragmentMusic - urMusic is null");
      }
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exists audio_url = ");
      localStringBuilder.append(str);
      localStringBuilder.append(", path = ");
      localStringBuilder.append(paramQQStoryMusicInfo);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
    {
      f();
      QQToast.a(BaseApplication.getContext(), 2131695217, 0).a();
      return;
    }
    this.jdField_b_of_type_JavaUtilHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
    this.jdField_a_of_type_JavaUtilHashMap.put(str, paramQQStoryMusicInfo);
    paramQQStoryMusicInfo = this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp;
    if ((paramQQStoryMusicInfo != null) && (paramQQStoryMusicInfo.a()))
    {
      com.tencent.mobileqq.utils.FileUtils.deleteFile(this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a());
      this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a();
    }
    ThreadManager.post(new P2VEditMusicDialog.3(this, str), 5, null, true);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject1 = QQStoryBGMusicUtils.a(paramString);
    Object localObject2;
    if (paramInt == 0)
    {
      this.jdField_d_of_type_Int = 0;
      if (QLog.isColorLevel())
      {
        localObject2 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDownloadFinish() url = ");
        localStringBuilder.append(paramString);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a();
      if ((localObject2 != null) && (paramString.equals(((QQStoryMusicInfo)localObject2).jdField_d_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a((String)localObject1);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        getContext().getSharedPreferences("VideoMusicCache", 0).edit().putString(((QQStoryMusicInfo)localObject2).jdField_a_of_type_JavaLangString, (String)localObject1).apply();
      }
      StoryReportor.a("edit_video", "music_download_success", 0, 0, new String[] { "", "", "", "" });
    }
    else
    {
      StoryReportor.a("edit_video", "music_download_failed", 0, 0, new String[] { String.valueOf(paramInt), "", "", "" });
      VideoEditReport.a("0X80076D9");
    }
    if (QLog.isColorLevel())
    {
      long l = ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).longValue();
      localObject2 = new StringBuffer("onDownloadFinish errCode = ");
      ((StringBuffer)localObject2).append(paramInt);
      ((StringBuffer)localObject2).append(", name = ");
      ((StringBuffer)localObject2).append(com.tencent.biz.qqstory.utils.FileUtils.b(paramString));
      ((StringBuffer)localObject2).append(", downloadTime = ");
      ((StringBuffer)localObject2).append(System.currentTimeMillis() - l);
      ((StringBuffer)localObject2).append(", fileSize = ");
      ((StringBuffer)localObject2).append(com.tencent.biz.qqstory.utils.FileUtils.a((String)localObject1));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(", url = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuffer)localObject2).append(((StringBuilder)localObject1).toString());
      QLog.d(jdField_a_of_type_JavaLangString, 2, ((StringBuffer)localObject2).toString());
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
      if (QLog.isColorLevel())
      {
        paramString = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onProgress() mIndex = ");
        localStringBuilder.append(this.jdField_d_of_type_Int);
        localStringBuilder.append(", progress = ");
        localStringBuilder.append(f1);
        localStringBuilder.append(", cur = ");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append(", size = ");
        localStringBuilder.append(paramLong2);
        QLog.d(paramString, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadStart() url = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", dstPath = ");
      localStringBuilder.append(paramString2);
      QLog.d(str, 2, localStringBuilder.toString());
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
    int j = (paramInt2 - paramInt1) / 1000 * 1000;
    int i = j;
    if (j < 1000) {
      i = 1000;
    }
    j = i;
    if (this.jdField_c_of_type_Int == 1)
    {
      double d1 = i;
      j = i;
      if (d1 > 8500.0D)
      {
        j = i;
        if (d1 < 13500.0D) {
          j = 10000;
        }
      }
    }
    i = j + paramInt1;
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", end = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", displayEnd = ");
      localStringBuilder.append(i);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(TimeFormatterUtils.a(paramInt1, false));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(TimeFormatterUtils.a(i, true));
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
    DownloaderImp localDownloaderImp = this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp;
    if ((localDownloaderImp != null) && (localDownloaderImp.a()))
    {
      com.tencent.mobileqq.utils.FileUtils.deleteFile(this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a());
      this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a();
    }
    ((AddressDataProvider)((DataProviderManager)SuperManager.a(20)).a(1)).b(this.jdField_a_of_type_ComTencentBizQqstoryModelDataProvider$DataUpdateListener);
    e();
    c();
    super.dismiss();
  }
  
  protected void e()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilTimer;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask;
    if (localObject != null)
    {
      ((P2VEditMusicDialog.MusicPlayTask)localObject).cancel();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask = null;
    }
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
  }
  
  protected void f()
  {
    QQStoryMusicInfo localQQStoryMusicInfo = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a();
    if ((localQQStoryMusicInfo != null) && (localQQStoryMusicInfo.jdField_b_of_type_Int == 3))
    {
      MusicGridAdapter localMusicGridAdapter = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter;
      if ((localMusicGridAdapter != null) && (localMusicGridAdapter.a(localQQStoryMusicInfo) > 0) && (!localQQStoryMusicInfo.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a())))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(localQQStoryMusicInfo);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.notifyDataSetChanged();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "checkButtonState 按钮错位!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
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
    default: 
      break;
    case 2131371620: 
      h();
      break;
    case 2131371619: 
      g();
      dismiss();
      break;
    case 2131365743: 
      h();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter;
    if (localObject != null)
    {
      localObject = (QQStoryMusicInfo)((MusicGridAdapter)localObject).getItem(paramInt);
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onItemClick error musicInfo = ");
          localStringBuilder.append(null);
          QLog.e((String)localObject, 2, localStringBuilder.toString());
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a((QQStoryMusicInfo)localObject);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.notifyDataSetChanged();
        if (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a())
        {
          b();
          if (((QQStoryMusicInfo)localObject).jdField_b_of_type_Int == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a((QQStoryMusicInfo)localObject);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
          }
          else if (((QQStoryMusicInfo)localObject).jdField_b_of_type_Int == 1)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a((QQStoryMusicInfo)localObject);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
          }
          else if (((QQStoryMusicInfo)localObject).jdField_b_of_type_Int == 2)
          {
            if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
            {
              f();
              QQToast.a(BaseApplication.getContext(), 2131695217, 0).a();
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
          if (!TextUtils.isEmpty(((QQStoryMusicInfo)localObject).jdField_d_of_type_JavaLangString))
          {
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(((QQStoryMusicInfo)localObject).jdField_b_of_type_JavaLangString);
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$IP2VMusicEditListener.a((QQStoryMusicInfo)localObject);
          a((QQStoryMusicInfo)localObject);
          StoryReportor.a("video_edit", "add_music", 0, 0, new String[] { "1", "", "", "" });
        }
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog
 * JD-Core Version:    0.7.0.1
 */