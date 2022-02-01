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
import anvx;
import bhdj;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MusicConfigInfo;
import com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.FileUtils;
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
import wam;
import waz;
import wfi;
import wfk;
import wik;
import win;
import wis;
import wit;
import wjs;
import wth;
import wvb;
import ykv;
import ykw;
import ynw;
import yoi;
import ywu;
import ywx;
import yxb;
import yxc;
import yxd;
import yxe;
import yxf;
import yxh;
import yxi;
import yxj;
import yxk;
import zeb;

@TargetApi(11)
public class EditVideoMusicDialog
  extends Dialog
  implements View.OnClickListener, AdapterView.OnItemClickListener, wam, wfk<wth, wvb>, yxi
{
  public int a;
  protected long a;
  public Handler a;
  public View a;
  protected GridView a;
  public ProgressBar a;
  public TextView a;
  public EditVideoMusic a;
  protected EditVideoParams a;
  protected EditVideoMusicDialog.MusicPlayTask a;
  public MusicHorizontalSeekView a;
  protected Timer a;
  protected ConcurrentHashMap<String, String> a;
  protected waz a;
  private wis<win> jdField_a_of_type_Wis = new yxf(this);
  public ywu a;
  private ywx jdField_a_of_type_Ywx;
  public yxh a;
  public yxk a;
  public final boolean a;
  public int b;
  protected long b;
  public View b;
  public TextView b;
  protected ConcurrentHashMap<String, Long> b;
  public boolean b;
  protected int c;
  protected View c;
  protected TextView c;
  public boolean c;
  protected int d;
  protected TextView d;
  protected boolean d;
  protected int e;
  protected TextView e;
  protected volatile int f;
  protected TextView f;
  
  public EditVideoMusicDialog(Context paramContext, EditVideoMusic paramEditVideoMusic, boolean paramBoolean1, int paramInt, EditVideoParams paramEditVideoParams, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramContext, 2131755166);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_a_of_type_AndroidOsHandler = new yxc(this);
    super.requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic = paramEditVideoMusic;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_d_of_type_Boolean = paramBoolean3;
    this.jdField_a_of_type_Ywx = new ywx(paramContext, new yxb(this), this.jdField_a_of_type_AndroidOsHandler);
    a(paramContext);
    paramContext = super.getWindow().getAttributes();
    paramContext.x = 0;
    paramContext.y = 0;
    paramContext.width = -1;
    paramContext.height = UIUtils.getWindowScreenHeight(getContext());
    paramContext.windowAnimations = 2131755184;
    paramContext.gravity = 83;
    super.getWindow().setBackgroundDrawable(new ColorDrawable());
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "pressCancelBtn");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(this.jdField_a_of_type_Yxk);
    if (this.jdField_a_of_type_Yxk != null)
    {
      this.jdField_a_of_type_Yxk.jdField_d_of_type_Int = this.jdField_d_of_type_Int;
      this.jdField_a_of_type_Yxk.jdField_e_of_type_Int = this.jdField_e_of_type_Int;
      if (this.jdField_a_of_type_Yxk.jdField_b_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        return;
      }
      if (this.jdField_a_of_type_Yxk.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Yxk.g))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(yxk.jdField_b_of_type_Yxk);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(yxk.jdField_b_of_type_Yxk);
  }
  
  private void g()
  {
    int j = 1;
    yxk localyxk = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    int i = j;
    if (localyxk != null)
    {
      i = j;
      if (this.jdField_a_of_type_Yxk != null)
      {
        if ((localyxk.jdField_b_of_type_Int == 3) || (localyxk.jdField_b_of_type_Int == 2)) {
          break label108;
        }
        i = j;
      }
    }
    while ((this.jdField_d_of_type_Boolean) && (i != 0))
    {
      bhdj.a(getContext(), 230).setMessage(anvx.a(2131703266)).setPositiveButton(anvx.a(2131703247), new yxe(this)).setNegativeButton(anvx.a(2131703190), new yxd(this)).show();
      return;
      label108:
      i = j;
      if (localyxk.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Yxk.jdField_a_of_type_JavaLangString)) {
        i = 0;
      }
    }
    dismiss();
  }
  
  public int a()
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
      ykv.a("video_edit", "cut_music", 0, 0, new String[] { str, "", "", "" });
      ykw.a("0X80076DA");
      return;
    }
  }
  
  public void a(Context paramContext)
  {
    Object localObject = LayoutInflater.from(paramContext).inflate(2131561735, null);
    super.setContentView((View)localObject);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = (this.jdField_a_of_type_Int / 4);
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject).findViewById(2131371708));
      this.jdField_b_of_type_AndroidViewView = ((View)localObject).findViewById(2131371692);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView = ((MusicHorizontalSeekView)((View)localObject).findViewById(2131371694));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setOnSeekListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131371695));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377271));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377270));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131371704));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131371705));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366145));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131377321);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.b()) {
        break label575;
      }
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)((View)localObject).findViewById(2131371693));
      this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(-1);
      this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
      }
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this);
      this.jdField_c_of_type_AndroidViewView = ((View)localObject).findViewById(2131365742);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_Yxh = new yxh(paramContext, this.jdField_a_of_type_AndroidWidgetGridView, this.jdField_a_of_type_Boolean, a(this.jdField_c_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Yxh);
      this.jdField_a_of_type_Yxh.a(null);
      label340:
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      if (localObject == null)
      {
        EditVideoMusic localEditVideoMusic = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic;
        if (!this.jdField_a_of_type_Boolean) {
          break label616;
        }
        paramContext = yxk.jdField_a_of_type_Yxk;
        label369:
        localEditVideoMusic.a(paramContext);
      }
      this.jdField_a_of_type_Yxk = ((yxk)localObject);
      this.jdField_d_of_type_Int = ((yxk)localObject).jdField_d_of_type_Int;
      this.jdField_e_of_type_Int = ((yxk)localObject).jdField_e_of_type_Int;
      this.jdField_c_of_type_Boolean = ynw.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEnableMasks, 512);
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Ywu = new ywu(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams, this.jdField_a_of_type_AndroidOsHandler);
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
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList = yxk.a(getContext());
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      if (i != 0)
      {
        if (!NetworkUtil.isNetSupport(getContext())) {
          break label628;
        }
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        paramContext = new wth();
        wfi.a().a(paramContext, this);
      }
      return;
      if (this.jdField_a_of_type_Int < 5000)
      {
        this.jdField_a_of_type_Long = (this.jdField_a_of_type_Int / 6);
        break;
      }
      this.jdField_a_of_type_Long = 1000L;
      break;
      ((View)localObject).findViewById(2131365661).getLayoutParams().height = AIOUtils.dp2px(138.0F, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a());
      ((View)localObject).findViewById(2131371696).setVisibility(8);
      break label340;
      paramContext = yxk.jdField_b_of_type_Yxk;
      break label369;
    }
    label628:
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    QQToast.a(getContext(), anvx.a(2131703245), 0).a();
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = yxj.a(paramString);
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
      if ((localObject != null) && (paramString.equals(((yxk)localObject).jdField_d_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(str);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        getContext().getSharedPreferences("VideoMusicCache", 0).edit().putString(((yxk)localObject).jdField_a_of_type_JavaLangString, str).commit();
      }
      ykv.a("edit_video", "music_download_success", 0, 0, new String[] { "", "", "", "" });
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        long l = ((Long)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onDownloadFinish errCode = " + paramInt + ", name = " + zeb.b(paramString) + ", downloadTime = " + (System.currentTimeMillis() - l) + ", fileSize = " + zeb.a(str) + new StringBuilder().append(", url = ").append(paramString).toString());
      }
      return;
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      if ((localObject != null) && (paramString != null) && (paramString.equals(((yxk)localObject).jdField_d_of_type_JavaLangString)))
      {
        if (paramInt != 6)
        {
          localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7, getContext().getResources().getString(2131698028));
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
        }
        f();
      }
      ykv.a("edit_video", "music_download_failed", 0, 0, new String[] { String.valueOf(paramInt), "", "", "" });
      ykw.a("0X80076D9");
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
  
  public void a(wth paramwth, wvb paramwvb, ErrorMessage paramErrorMessage)
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
    for (paramwth = "null";; paramwth = paramErrorMessage.getErrorMessage())
    {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, paramwth);
      ykv.a("edit_video", "music_list_time", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long), "", "", "" });
      if ((paramErrorMessage == null) || (!paramErrorMessage.isFail())) {
        break;
      }
      paramwth = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
      paramwth.obj = ("onCmdRespond error = " + paramErrorMessage.getErrorMessage());
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramwth);
      ykv.a("edit_video", "music_list_failed", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    paramwth = paramwvb.a;
    int j = paramwth.music_config.size();
    paramwvb = new ArrayList(j);
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        paramwvb.add(new yxk((qqstory_struct.MusicConfigInfo)paramwth.music_config.get(i)));
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "GetMusicConfigResponse size = " + j);
      }
    }
    for (;;)
    {
      ykv.a("edit_video", "music_list_count", 0, 0, new String[] { String.valueOf(j), "", "", "" });
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList = paramwvb;
      yxk.a(getContext(), paramwvb);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onCmdRespond data is NULL!!!!!");
      }
    }
  }
  
  public void a(yxk paramyxk)
  {
    String str = paramyxk.jdField_d_of_type_JavaLangString;
    Object localObject = paramyxk.g;
    if ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramyxk = (yxk)localObject;
      if (!zeb.e((String)localObject)) {
        paramyxk = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      }
      localObject = paramyxk;
      if (!zeb.e(paramyxk)) {
        localObject = yxj.a(str);
      }
      if (!zeb.e((String)localObject)) {
        break label171;
      }
      if ((this.jdField_a_of_type_Waz != null) && (this.jdField_a_of_type_Waz.a()))
      {
        FileUtils.deleteFile(this.jdField_a_of_type_Waz.a());
        this.jdField_a_of_type_Waz.a();
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
    if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
    {
      e();
      QQToast.a(BaseApplication.getContext(), 2131694983, 0).a();
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject);
    if ((this.jdField_a_of_type_Waz != null) && (this.jdField_a_of_type_Waz.a()))
    {
      FileUtils.deleteFile(this.jdField_a_of_type_Waz.a());
      this.jdField_a_of_type_Waz.a();
    }
    ThreadManager.post(new EditVideoMusicDialog.3(this, str), 5, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    d();
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.j();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.k();
    yxk localyxk = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    yoi localyoi;
    if (localyxk != null)
    {
      localyoi = (yoi)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_Ynw.a(yoi.class);
      if (localyoi != null) {
        if ((localyxk.jdField_b_of_type_Int != 2) && (localyxk.jdField_b_of_type_Int != 3) && (localyxk.jdField_b_of_type_Int != 0)) {
          break label88;
        }
      }
    }
    label88:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localyoi.a(paramBoolean);
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
  
  public void b(int paramInt1, int paramInt2)
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
      this.jdField_c_of_type_AndroidWidgetTextView.setText(yxj.a(paramInt1, false));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(yxj.a(i, false));
      return;
      i = j;
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    yxk localyxk = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    if (localyxk != null)
    {
      paramInt2 = localyxk.jdField_f_of_type_Int;
      localyxk.jdField_d_of_type_Int = ((int)(paramInt2 * (paramInt3 / paramInt1)));
      localyxk.jdField_e_of_type_Int = (localyxk.jdField_d_of_type_Int + this.jdField_a_of_type_Int);
      if ((localyxk.jdField_e_of_type_Int > paramInt2) && (paramInt2 > this.jdField_a_of_type_Int))
      {
        localyxk.jdField_e_of_type_Int = paramInt2;
        localyxk.jdField_d_of_type_Int = (paramInt2 - this.jdField_a_of_type_Int);
      }
      b(localyxk.jdField_d_of_type_Int, localyxk.jdField_e_of_type_Int);
    }
  }
  
  public void b(yxk paramyxk)
  {
    if ((!TextUtils.isEmpty(paramyxk.jdField_d_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramyxk.g)))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramyxk.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramyxk);
    a(paramyxk);
    ykw.a("0X80076D6");
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
  
  public void d()
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
    this.jdField_a_of_type_Ywx.a();
    if ((this.jdField_a_of_type_Waz != null) && (this.jdField_a_of_type_Waz.a()))
    {
      FileUtils.deleteFile(this.jdField_a_of_type_Waz.a());
      this.jdField_a_of_type_Waz.a();
    }
    ((wik)((wit)wjs.a(20)).a(1)).b(this.jdField_a_of_type_Wis);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
    super.dismiss();
  }
  
  protected void e()
  {
    yxk localyxk = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    if ((localyxk != null) && (localyxk.jdField_b_of_type_Int == 3) && (this.jdField_a_of_type_Yxh.a(localyxk) > 0) && (localyxk != null) && (!localyxk.equals(this.jdField_a_of_type_Yxh.a())))
    {
      this.jdField_a_of_type_Yxh.a(localyxk);
      this.jdField_a_of_type_Yxh.notifyDataSetChanged();
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
      ykw.a("0X80076DB");
      dismiss();
      continue;
      ykw.a("0X80076DC");
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
    yxk localyxk;
    if (this.jdField_a_of_type_Yxh != null)
    {
      localyxk = (yxk)this.jdField_a_of_type_Yxh.getItem(paramInt);
      if (localyxk != null) {
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
      this.jdField_a_of_type_Yxh.a(localyxk);
      this.jdField_a_of_type_Yxh.notifyDataSetChanged();
      b();
      if (paramInt < this.jdField_a_of_type_Yxh.a())
      {
        if (localyxk.jdField_b_of_type_Int == 0)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(localyxk);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
          if (this.jdField_a_of_type_Boolean) {}
          for (localObject = "2";; localObject = "1")
          {
            ykv.a("video_edit", "close_music", 0, 0, new String[] { localObject, "", "", "" });
            ykw.a("0X80076D3");
            break;
          }
        }
        if (localyxk.jdField_b_of_type_Int == 1)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(localyxk);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
          if (this.jdField_a_of_type_Boolean) {}
          for (localObject = "2";; localObject = "1")
          {
            ykv.a("video_edit", "clk_video_sound", 0, 0, new String[] { localObject, "", "", "" });
            ykw.a("0X80076D4");
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a("608", "3", "2", true);
            break;
          }
        }
        if (localyxk.jdField_b_of_type_Int == 2) {
          if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
          {
            e();
            QQToast.a(BaseApplication.getContext(), 2131694983, 0).a();
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "click add qqmusic");
            }
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.c(false);
            d();
            localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
            int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId;
            if ((localObject instanceof BaseActivity)) {
              yxj.a((BaseActivity)localObject, i);
            }
            if (this.jdField_a_of_type_Boolean) {}
            for (localObject = "2";; localObject = "1")
            {
              ykv.a("video_edit", "add_qqmusic", 0, 0, new String[] { localObject, "", "", "" });
              ykw.a("0X80076D5");
              this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a("608", "3", "1", true);
              break;
            }
          }
        }
      }
      else
      {
        if (localyxk.jdField_b_of_type_Int != 4) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(yxk.jdField_a_of_type_Yxk);
        if (this.jdField_a_of_type_Ywu != null) {
          this.jdField_a_of_type_Ywu.a(localyxk);
        }
      }
    }
    if (!TextUtils.isEmpty(localyxk.jdField_d_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localyxk.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(localyxk);
    a(localyxk);
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = "2";; localObject = "1")
    {
      ykv.a("video_edit", "add_music", 0, 0, new String[] { localObject, "", "", "" });
      ykw.a("0X80076D8", "", "", localyxk.jdField_b_of_type_JavaLangString, "");
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a("608", "3", "1", true);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog
 * JD-Core Version:    0.7.0.1
 */