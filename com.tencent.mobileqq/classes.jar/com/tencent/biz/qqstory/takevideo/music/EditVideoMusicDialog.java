package com.tencent.biz.qqstory.takevideo.music;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
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
import com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.biz.qqstory.takevideo.EditVideoPlayerExport;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(11)
public class EditVideoMusicDialog
  extends Dialog
  implements View.OnClickListener, AdapterView.OnItemClickListener, DownloadProgressListener, CmdTaskManger.CommandCallback<GetMusicConfigRequest, GetMusicConfigResponse>, MusicHorizontalSeekView.SeekListener
{
  protected int a;
  protected long a;
  protected Handler a;
  protected View a;
  protected GridView a;
  protected ProgressBar a;
  protected TextView a;
  protected DownloaderImp a;
  private DataProvider.DataUpdateListener<AddressDataProvider.AddressInfo> jdField_a_of_type_ComTencentBizQqstoryModelDataProvider$DataUpdateListener = new EditVideoMusicDialog.6(this);
  protected EditVideoMusic a;
  protected EditVideoParams a;
  protected BlessVoiceChangeManager a;
  private EditVideoMusicCache jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicCache;
  protected EditVideoMusicDialog.MusicPlayTask a;
  protected MusicGridAdapter a;
  protected MusicHorizontalSeekView a;
  protected QQStoryMusicInfo a;
  protected Timer a;
  protected ConcurrentHashMap<String, String> a;
  protected final boolean a;
  protected int b;
  protected long b;
  protected View b;
  protected TextView b;
  protected ConcurrentHashMap<String, Long> b;
  protected boolean b;
  protected int c;
  protected View c;
  protected TextView c;
  protected boolean c;
  protected int d;
  protected TextView d;
  protected boolean d;
  protected int e;
  protected TextView e;
  protected volatile int f;
  protected TextView f;
  
  public EditVideoMusicDialog(Context paramContext, EditVideoMusic paramEditVideoMusic, boolean paramBoolean1, int paramInt, EditVideoParams paramEditVideoParams, boolean paramBoolean2, boolean paramBoolean3)
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
    this.jdField_e_of_type_AndroidWidgetTextView = null;
    this.jdField_f_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_c_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp = null;
    this.jdField_a_of_type_JavaUtilTimer = null;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicBlessVoiceChangeManager = null;
    this.jdField_a_of_type_AndroidOsHandler = new EditVideoMusicDialog.2(this);
    this.jdField_f_of_type_Int = 0;
    super.requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic = paramEditVideoMusic;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_d_of_type_Boolean = paramBoolean3;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicCache = new EditVideoMusicCache(paramContext, new EditVideoMusicDialog.1(this), this.jdField_a_of_type_AndroidOsHandler);
    a(paramContext);
    paramContext = super.getWindow().getAttributes();
    paramContext.x = 0;
    paramContext.y = 0;
    paramContext.width = -1;
    paramContext.height = UIUtils.d(getContext());
    paramContext.windowAnimations = 2131755186;
    paramContext.gravity = 83;
    super.getWindow().setBackgroundDrawable(new ColorDrawable());
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "pressCancelBtn");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_d_of_type_Int = this.jdField_d_of_type_Int;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_e_of_type_Int = this.jdField_e_of_type_Int;
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
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(QQStoryMusicInfo.jdField_b_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(QQStoryMusicInfo.jdField_b_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
  }
  
  private void g()
  {
    int j = 1;
    QQStoryMusicInfo localQQStoryMusicInfo = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    int i = j;
    if (localQQStoryMusicInfo != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo != null)
      {
        if ((localQQStoryMusicInfo.jdField_b_of_type_Int == 3) || (localQQStoryMusicInfo.jdField_b_of_type_Int == 2)) {
          break label111;
        }
        i = j;
      }
    }
    while ((this.jdField_d_of_type_Boolean) && (i != 0))
    {
      DialogUtil.a(getContext(), 230).setMessage(HardCodeUtil.a(2131703814)).setPositiveButton(HardCodeUtil.a(2131703795), new EditVideoMusicDialog.5(this)).setNegativeButton(HardCodeUtil.a(2131703738), new EditVideoMusicDialog.4(this)).show();
      return;
      label111:
      i = j;
      if (localQQStoryMusicInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_a_of_type_JavaLangString)) {
        i = 0;
      }
    }
    dismiss();
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
    e();
    c();
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
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "2";; str = "1")
    {
      StoryReportor.a("video_edit", "cut_music", 0, 0, new String[] { str, "", "", "" });
      VideoEditReport.a("0X80076DA");
      return;
    }
  }
  
  public void a(Context paramContext)
  {
    Object localObject = LayoutInflater.from(paramContext).inflate(2131561867, null);
    super.setContentView((View)localObject);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = (this.jdField_a_of_type_Int / 4);
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject).findViewById(2131372022));
      this.jdField_b_of_type_AndroidViewView = ((View)localObject).findViewById(2131372005);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView = ((MusicHorizontalSeekView)((View)localObject).findViewById(2131372007));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setOnSeekListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131372008));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377692));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377691));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131372017));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131372018));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366317));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131377742);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.b()) {
        break label575;
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
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter = new MusicGridAdapter(paramContext, this.jdField_a_of_type_AndroidWidgetGridView, this.jdField_a_of_type_Boolean, a(this.jdField_c_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(null);
      label340:
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      if (localObject == null)
      {
        EditVideoMusic localEditVideoMusic = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic;
        if (!this.jdField_a_of_type_Boolean) {
          break label616;
        }
        paramContext = QQStoryMusicInfo.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
        label369:
        localEditVideoMusic.a(paramContext);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = ((QQStoryMusicInfo)localObject);
      this.jdField_d_of_type_Int = ((QQStoryMusicInfo)localObject).jdField_d_of_type_Int;
      this.jdField_e_of_type_Int = ((QQStoryMusicInfo)localObject).jdField_e_of_type_Int;
      this.jdField_c_of_type_Boolean = EditVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 512);
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicBlessVoiceChangeManager = new BlessVoiceChangeManager(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams, this.jdField_a_of_type_AndroidOsHandler);
      }
      if (a(this.jdField_c_of_type_Int)) {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
          break label623;
        }
      }
    }
    label575:
    label616:
    label623:
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList = QQStoryMusicInfo.a(getContext());
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      if (i != 0)
      {
        if (!NetworkUtil.d(getContext())) {
          break label628;
        }
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        paramContext = new GetMusicConfigRequest();
        CmdTaskManger.a().a(paramContext, this);
      }
      return;
      if (this.jdField_a_of_type_Int < 5000)
      {
        this.jdField_a_of_type_Long = (this.jdField_a_of_type_Int / 6);
        break;
      }
      this.jdField_a_of_type_Long = 1000L;
      break;
      ((View)localObject).findViewById(2131365824).getLayoutParams().height = AIOUtils.a(138.0F, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a());
      ((View)localObject).findViewById(2131372009).setVisibility(8);
      break label340;
      paramContext = QQStoryMusicInfo.jdField_b_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
      break label369;
    }
    label628:
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    QQToast.a(getContext(), HardCodeUtil.a(2131703793), 0).a();
  }
  
  public void a(GetMusicConfigRequest paramGetMusicConfigRequest, GetMusicConfigResponse paramGetMusicConfigResponse, ErrorMessage paramErrorMessage)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onCmdRespond = ").append(System.currentTimeMillis() - this.jdField_b_of_type_Long).append(", errorMsg = ");
      if (paramErrorMessage != null) {
        break label205;
      }
    }
    label205:
    for (paramGetMusicConfigRequest = "null";; paramGetMusicConfigRequest = paramErrorMessage.getErrorMessage())
    {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, paramGetMusicConfigRequest);
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
    paramGetMusicConfigRequest = paramGetMusicConfigResponse.a;
    int j = paramGetMusicConfigRequest.music_config.size();
    paramGetMusicConfigResponse = new ArrayList(j);
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        paramGetMusicConfigResponse.add(new QQStoryMusicInfo((qqstory_struct.MusicConfigInfo)paramGetMusicConfigRequest.music_config.get(i)));
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "GetMusicConfigResponse size = " + j);
      }
    }
    for (;;)
    {
      StoryReportor.a("edit_video", "music_list_count", 0, 0, new String[] { String.valueOf(j), "", "", "" });
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList = paramGetMusicConfigResponse;
      QQStoryMusicInfo.a(getContext(), paramGetMusicConfigResponse);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onCmdRespond data is NULL!!!!!");
      }
    }
  }
  
  protected void a(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    String str = paramQQStoryMusicInfo.jdField_d_of_type_JavaLangString;
    Object localObject = paramQQStoryMusicInfo.g;
    if ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramQQStoryMusicInfo = (QQStoryMusicInfo)localObject;
      if (!com.tencent.biz.qqstory.utils.FileUtils.e((String)localObject)) {
        paramQQStoryMusicInfo = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      }
      localObject = paramQQStoryMusicInfo;
      if (!com.tencent.biz.qqstory.utils.FileUtils.e(paramQQStoryMusicInfo)) {
        localObject = QQStoryBGMusicUtils.a(str);
      }
      if (!com.tencent.biz.qqstory.utils.FileUtils.e((String)localObject)) {
        break label171;
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a()))
      {
        com.tencent.mobileqq.utils.FileUtils.e(this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a());
        this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a();
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a() != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a((String)localObject);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "exists audio_url = " + str + ", path = " + (String)localObject);
      }
    }
    return;
    label171:
    if (!NetworkUtil.g(BaseApplication.getContext()))
    {
      e();
      QQToast.a(BaseApplication.getContext(), 2131695222, 0).a();
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a()))
    {
      com.tencent.mobileqq.utils.FileUtils.e(this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a());
      this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a();
    }
    ThreadManager.post(new EditVideoMusicDialog.3(this, str), 5, null, true);
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = QQStoryBGMusicUtils.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, new Object[] { "onDownloadFinish() url:", paramString, " errCode:", Integer.valueOf(paramInt) });
    }
    Object localObject;
    if (paramInt == 0)
    {
      this.jdField_f_of_type_Int = 0;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, str);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      if ((localObject != null) && (paramString.equals(((QQStoryMusicInfo)localObject).jdField_d_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(str);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        getContext().getSharedPreferences("VideoMusicCache", 0).edit().putString(((QQStoryMusicInfo)localObject).jdField_a_of_type_JavaLangString, str).commit();
      }
      StoryReportor.a("edit_video", "music_download_success", 0, 0, new String[] { "", "", "", "" });
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        long l = ((Long)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onDownloadFinish errCode = " + paramInt + ", name = " + com.tencent.biz.qqstory.utils.FileUtils.b(paramString) + ", downloadTime = " + (System.currentTimeMillis() - l) + ", fileSize = " + com.tencent.biz.qqstory.utils.FileUtils.a(str) + new StringBuilder().append(", url = ").append(paramString).toString());
      }
      return;
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      if ((localObject != null) && (paramString != null) && (paramString.equals(((QQStoryMusicInfo)localObject).jdField_d_of_type_JavaLangString)))
      {
        if (paramInt != 6)
        {
          localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7, getContext().getResources().getString(2131698304));
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
        }
        f();
      }
      StoryReportor.a("edit_video", "music_download_failed", 0, 0, new String[] { String.valueOf(paramInt), "", "", "" });
      VideoEditReport.a("0X80076D9");
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    float f1 = (float)paramLong1 / (float)paramLong2;
    if (f1 >= this.jdField_f_of_type_Int * 0.05F)
    {
      this.jdField_f_of_type_Int += 1;
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
      paramString.arg1 = ((int)(100.0F * f1));
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onProgress() mIndex = " + this.jdField_f_of_type_Int + ", progress = " + f1 + ", cur = " + paramLong1 + ", size = " + paramLong2);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onDownloadStart() url = " + paramString1 + ", dstPath = " + paramString2);
    }
    this.jdField_f_of_type_Int = 0;
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
    paramString1.arg1 = 0;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
  }
  
  protected void a(boolean paramBoolean)
  {
    d();
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.j();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.k();
    QQStoryMusicInfo localQQStoryMusicInfo = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    EditVideoPlayerExport localEditVideoPlayerExport;
    if (localQQStoryMusicInfo != null)
    {
      localEditVideoPlayerExport = (EditVideoPlayerExport)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
      if (localEditVideoPlayerExport != null) {
        if ((localQQStoryMusicInfo.jdField_b_of_type_Int != 2) && (localQQStoryMusicInfo.jdField_b_of_type_Int != 3) && (localQQStoryMusicInfo.jdField_b_of_type_Int != 0)) {
          break label88;
        }
      }
    }
    label88:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localEditVideoPlayerExport.a(paramBoolean);
      return;
    }
  }
  
  protected boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 5) {
      bool = false;
    }
    return bool;
  }
  
  protected void b()
  {
    d();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.i();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.l();
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
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "start = " + paramInt1 + ", end = " + paramInt2 + ", displayEnd = " + i);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(QQStoryBGMusicUtils.a(paramInt1, false));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(QQStoryBGMusicUtils.a(i, false));
      return;
      i = j;
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    QQStoryMusicInfo localQQStoryMusicInfo = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    if (localQQStoryMusicInfo != null)
    {
      paramInt2 = localQQStoryMusicInfo.jdField_f_of_type_Int;
      localQQStoryMusicInfo.jdField_d_of_type_Int = ((int)(paramInt2 * (paramInt3 / paramInt1)));
      localQQStoryMusicInfo.jdField_e_of_type_Int = (localQQStoryMusicInfo.jdField_d_of_type_Int + this.jdField_a_of_type_Int);
      if ((localQQStoryMusicInfo.jdField_e_of_type_Int > paramInt2) && (paramInt2 > this.jdField_a_of_type_Int))
      {
        localQQStoryMusicInfo.jdField_e_of_type_Int = paramInt2;
        localQQStoryMusicInfo.jdField_d_of_type_Int = (paramInt2 - this.jdField_a_of_type_Int);
      }
      b(localQQStoryMusicInfo.jdField_d_of_type_Int, localQQStoryMusicInfo.jdField_e_of_type_Int);
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
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramQQStoryMusicInfo);
    a(paramQQStoryMusicInfo);
    VideoEditReport.a("0X80076D6");
  }
  
  public void c()
  {
    d();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask = new EditVideoMusicDialog.MusicPlayTask(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask, 0L, this.jdField_a_of_type_Long);
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, paramInt3);
    a(true);
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask.cancel();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask = null;
    }
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
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
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
    super.dismiss();
  }
  
  protected void e()
  {
    QQStoryMusicInfo localQQStoryMusicInfo = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    if ((localQQStoryMusicInfo != null) && (localQQStoryMusicInfo.jdField_b_of_type_Int == 3) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(localQQStoryMusicInfo) > 0) && (localQQStoryMusicInfo != null) && (!localQQStoryMusicInfo.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a())))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(localQQStoryMusicInfo);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "checkButtonState 按钮错位!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      }
    }
  }
  
  public void onBackPressed()
  {
    f();
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
      f();
      VideoEditReport.a("0X80076DB");
      dismiss();
      continue;
      VideoEditReport.a("0X80076DC");
      g();
      continue;
      g();
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
        break label52;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onItemClick error musicInfo is null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label52:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(localQQStoryMusicInfo);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.notifyDataSetChanged();
      b();
      if (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a())
      {
        if (localQQStoryMusicInfo.jdField_b_of_type_Int == 0)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(localQQStoryMusicInfo);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
          if (this.jdField_a_of_type_Boolean) {}
          for (localObject = "2";; localObject = "1")
          {
            StoryReportor.a("video_edit", "close_music", 0, 0, new String[] { localObject, "", "", "" });
            VideoEditReport.a("0X80076D3");
            break;
          }
        }
        if (localQQStoryMusicInfo.jdField_b_of_type_Int == 1)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(localQQStoryMusicInfo);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
          if (this.jdField_a_of_type_Boolean) {}
          for (localObject = "2";; localObject = "1")
          {
            StoryReportor.a("video_edit", "clk_video_sound", 0, 0, new String[] { localObject, "", "", "" });
            VideoEditReport.a("0X80076D4");
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a("608", "3", "2", true);
            break;
          }
        }
        if (localQQStoryMusicInfo.jdField_b_of_type_Int == 2) {
          if (!NetworkUtil.g(BaseApplication.getContext()))
          {
            e();
            QQToast.a(BaseApplication.getContext(), 2131695222, 0).a();
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "click add qqmusic");
            }
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.c(false);
            d();
            localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
            int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int;
            if ((localObject instanceof BaseActivity)) {
              QQStoryBGMusicUtils.a((BaseActivity)localObject, i);
            }
            if (this.jdField_a_of_type_Boolean) {}
            for (localObject = "2";; localObject = "1")
            {
              StoryReportor.a("video_edit", "add_qqmusic", 0, 0, new String[] { localObject, "", "", "" });
              VideoEditReport.a("0X80076D5");
              this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a("608", "3", "1", true);
              break;
            }
          }
        }
      }
      else
      {
        if (localQQStoryMusicInfo.jdField_b_of_type_Int != 4) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(QQStoryMusicInfo.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicBlessVoiceChangeManager != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicBlessVoiceChangeManager.a(localQQStoryMusicInfo);
        }
      }
    }
    if (!TextUtils.isEmpty(localQQStoryMusicInfo.jdField_d_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localQQStoryMusicInfo.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(localQQStoryMusicInfo);
    a(localQQStoryMusicInfo);
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = "2";; localObject = "1")
    {
      StoryReportor.a("video_edit", "add_music", 0, 0, new String[] { localObject, "", "", "" });
      VideoEditReport.a("0X80076D8", "", "", localQQStoryMusicInfo.jdField_b_of_type_JavaLangString, "");
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a("608", "3", "1", true);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog
 * JD-Core Version:    0.7.0.1
 */