package com.tencent.biz.qqstory.takevideo.music;

import aekt;
import alpo;
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
import bdcd;
import bdcs;
import bdee;
import bdfq;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MusicConfigInfo;
import com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import uic;
import uip;
import ung;
import uni;
import uqj;
import uqm;
import uqr;
import uqs;
import urr;
import vbg;
import vda;
import wta;
import wtb;
import wwe;
import wwq;
import xfm;
import xfp;
import xft;
import xfu;
import xfv;
import xfw;
import xfx;
import xfz;
import xga;
import xgb;
import xgc;
import xmx;
import xod;

@TargetApi(11)
public class EditVideoMusicDialog
  extends Dialog
  implements View.OnClickListener, AdapterView.OnItemClickListener, uic, uni<vbg, vda>, xga
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
  protected uip a;
  private uqr<uqm> jdField_a_of_type_Uqr = new xfx(this);
  public xfm a;
  private xfp jdField_a_of_type_Xfp;
  public xfz a;
  public xgc a;
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
    super(paramContext, 2131755164);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_a_of_type_AndroidOsHandler = new xfu(this);
    super.requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic = paramEditVideoMusic;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_d_of_type_Boolean = paramBoolean3;
    this.jdField_a_of_type_Xfp = new xfp(paramContext, new xft(this), this.jdField_a_of_type_AndroidOsHandler);
    a(paramContext);
    paramContext = super.getWindow().getAttributes();
    paramContext.x = 0;
    paramContext.y = 0;
    paramContext.width = -1;
    paramContext.height = xod.d(getContext());
    paramContext.windowAnimations = 2131755182;
    paramContext.gravity = 83;
    super.getWindow().setBackgroundDrawable(new ColorDrawable());
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "pressCancelBtn");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(this.jdField_a_of_type_Xgc);
    if (this.jdField_a_of_type_Xgc != null)
    {
      this.jdField_a_of_type_Xgc.jdField_d_of_type_Int = this.jdField_d_of_type_Int;
      this.jdField_a_of_type_Xgc.jdField_e_of_type_Int = this.jdField_e_of_type_Int;
      if (this.jdField_a_of_type_Xgc.jdField_b_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        return;
      }
      if (this.jdField_a_of_type_Xgc.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Xgc.g))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(xgc.jdField_b_of_type_Xgc);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(xgc.jdField_b_of_type_Xgc);
  }
  
  private void g()
  {
    int j = 1;
    xgc localxgc = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    int i = j;
    if (localxgc != null)
    {
      i = j;
      if (this.jdField_a_of_type_Xgc != null)
      {
        if ((localxgc.jdField_b_of_type_Int == 3) || (localxgc.jdField_b_of_type_Int == 2)) {
          break label108;
        }
        i = j;
      }
    }
    while ((this.jdField_d_of_type_Boolean) && (i != 0))
    {
      bdcd.a(getContext(), 230).setMessage(alpo.a(2131704164)).setPositiveButton(alpo.a(2131704145), new xfw(this)).setNegativeButton(alpo.a(2131704088), new xfv(this)).show();
      return;
      label108:
      i = j;
      if (localxgc.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Xgc.jdField_a_of_type_JavaLangString)) {
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
      wta.a("video_edit", "cut_music", 0, 0, new String[] { str, "", "", "" });
      wtb.a("0X80076DA");
      return;
    }
  }
  
  public void a(Context paramContext)
  {
    Object localObject = LayoutInflater.from(paramContext).inflate(2131561495, null);
    super.setContentView((View)localObject);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = (this.jdField_a_of_type_Int / 4);
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject).findViewById(2131370862));
      this.jdField_b_of_type_AndroidViewView = ((View)localObject).findViewById(2131370851);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView = ((MusicHorizontalSeekView)((View)localObject).findViewById(2131370853));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setOnSeekListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131370854));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131376275));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131376274));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370858));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370859));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365725));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131376313);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.b()) {
        break label575;
      }
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)((View)localObject).findViewById(2131370852));
      this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(-1);
      this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
      }
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this);
      this.jdField_c_of_type_AndroidViewView = ((View)localObject).findViewById(2131365337);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_Xfz = new xfz(paramContext, this.jdField_a_of_type_AndroidWidgetGridView, this.jdField_a_of_type_Boolean, a(this.jdField_c_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Xfz);
      this.jdField_a_of_type_Xfz.a(null);
      label340:
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      if (localObject == null)
      {
        EditVideoMusic localEditVideoMusic = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic;
        if (!this.jdField_a_of_type_Boolean) {
          break label616;
        }
        paramContext = xgc.jdField_a_of_type_Xgc;
        label369:
        localEditVideoMusic.a(paramContext);
      }
      this.jdField_a_of_type_Xgc = ((xgc)localObject);
      this.jdField_d_of_type_Int = ((xgc)localObject).jdField_d_of_type_Int;
      this.jdField_e_of_type_Int = ((xgc)localObject).jdField_e_of_type_Int;
      this.jdField_c_of_type_Boolean = wwe.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 512);
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Xfm = new xfm(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams, this.jdField_a_of_type_AndroidOsHandler);
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
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList = xgc.a(getContext());
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      if (i != 0)
      {
        if (!bdee.d(getContext())) {
          break label628;
        }
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        paramContext = new vbg();
        ung.a().a(paramContext, this);
      }
      return;
      if (this.jdField_a_of_type_Int < 5000)
      {
        this.jdField_a_of_type_Long = (this.jdField_a_of_type_Int / 6);
        break;
      }
      this.jdField_a_of_type_Long = 1000L;
      break;
      ((View)localObject).findViewById(2131365250).getLayoutParams().height = aekt.a(138.0F, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a());
      ((View)localObject).findViewById(2131370855).setVisibility(8);
      break label340;
      paramContext = xgc.jdField_b_of_type_Xgc;
      break label369;
    }
    label628:
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    QQToast.a(getContext(), alpo.a(2131704143), 0).a();
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = xgb.a(paramString);
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
      if ((localObject != null) && (paramString.equals(((xgc)localObject).jdField_d_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(str);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        getContext().getSharedPreferences("VideoMusicCache", 0).edit().putString(((xgc)localObject).jdField_a_of_type_JavaLangString, str).commit();
      }
      wta.a("edit_video", "music_download_success", 0, 0, new String[] { "", "", "", "" });
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        long l = ((Long)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onDownloadFinish errCode = " + paramInt + ", name = " + xmx.b(paramString) + ", downloadTime = " + (System.currentTimeMillis() - l) + ", fileSize = " + xmx.a(str) + new StringBuilder().append(", url = ").append(paramString).toString());
      }
      return;
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      if ((localObject != null) && (paramString != null) && (paramString.equals(((xgc)localObject).jdField_d_of_type_JavaLangString)))
      {
        if (paramInt != 6)
        {
          localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7, getContext().getResources().getString(2131698618));
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
        }
        f();
      }
      wta.a("edit_video", "music_download_failed", 0, 0, new String[] { String.valueOf(paramInt), "", "", "" });
      wtb.a("0X80076D9");
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
  
  public void a(vbg paramvbg, vda paramvda, ErrorMessage paramErrorMessage)
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
    for (paramvbg = "null";; paramvbg = paramErrorMessage.getErrorMessage())
    {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, paramvbg);
      wta.a("edit_video", "music_list_time", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long), "", "", "" });
      if ((paramErrorMessage == null) || (!paramErrorMessage.isFail())) {
        break;
      }
      paramvbg = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
      paramvbg.obj = ("onCmdRespond error = " + paramErrorMessage.getErrorMessage());
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramvbg);
      wta.a("edit_video", "music_list_failed", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    paramvbg = paramvda.a;
    int j = paramvbg.music_config.size();
    paramvda = new ArrayList(j);
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        paramvda.add(new xgc((qqstory_struct.MusicConfigInfo)paramvbg.music_config.get(i)));
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "GetMusicConfigResponse size = " + j);
      }
    }
    for (;;)
    {
      wta.a("edit_video", "music_list_count", 0, 0, new String[] { String.valueOf(j), "", "", "" });
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList = paramvda;
      xgc.a(getContext(), paramvda);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onCmdRespond data is NULL!!!!!");
      }
    }
  }
  
  public void a(xgc paramxgc)
  {
    String str = paramxgc.jdField_d_of_type_JavaLangString;
    Object localObject = paramxgc.g;
    if ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramxgc = (xgc)localObject;
      if (!xmx.e((String)localObject)) {
        paramxgc = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      }
      localObject = paramxgc;
      if (!xmx.e(paramxgc)) {
        localObject = xgb.a(str);
      }
      if (!xmx.e((String)localObject)) {
        break label171;
      }
      if ((this.jdField_a_of_type_Uip != null) && (this.jdField_a_of_type_Uip.a()))
      {
        bdcs.d(this.jdField_a_of_type_Uip.a());
        this.jdField_a_of_type_Uip.a();
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
    if (!bdee.g(BaseApplication.getContext()))
    {
      e();
      QQToast.a(BaseApplication.getContext(), 2131695727, 0).a();
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject);
    if ((this.jdField_a_of_type_Uip != null) && (this.jdField_a_of_type_Uip.a()))
    {
      bdcs.d(this.jdField_a_of_type_Uip.a());
      this.jdField_a_of_type_Uip.a();
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
    xgc localxgc = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    wwq localwwq;
    if (localxgc != null)
    {
      localwwq = (wwq)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_Wwe.a(wwq.class);
      if (localwwq != null) {
        if ((localxgc.jdField_b_of_type_Int != 2) && (localxgc.jdField_b_of_type_Int != 3) && (localxgc.jdField_b_of_type_Int != 0)) {
          break label88;
        }
      }
    }
    label88:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localwwq.a(paramBoolean);
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
      this.jdField_c_of_type_AndroidWidgetTextView.setText(xgb.a(paramInt1, false));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(xgb.a(i, false));
      return;
      i = j;
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    xgc localxgc = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    if (localxgc != null)
    {
      paramInt2 = localxgc.jdField_f_of_type_Int;
      localxgc.jdField_d_of_type_Int = ((int)(paramInt2 * (paramInt3 / paramInt1)));
      localxgc.jdField_e_of_type_Int = (localxgc.jdField_d_of_type_Int + this.jdField_a_of_type_Int);
      if ((localxgc.jdField_e_of_type_Int > paramInt2) && (paramInt2 > this.jdField_a_of_type_Int))
      {
        localxgc.jdField_e_of_type_Int = paramInt2;
        localxgc.jdField_d_of_type_Int = (paramInt2 - this.jdField_a_of_type_Int);
      }
      b(localxgc.jdField_d_of_type_Int, localxgc.jdField_e_of_type_Int);
    }
  }
  
  public void b(xgc paramxgc)
  {
    if ((!TextUtils.isEmpty(paramxgc.jdField_d_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramxgc.g)))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramxgc.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramxgc);
    a(paramxgc);
    wtb.a("0X80076D6");
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
    this.jdField_a_of_type_Xfp.a();
    if ((this.jdField_a_of_type_Uip != null) && (this.jdField_a_of_type_Uip.a()))
    {
      bdcs.d(this.jdField_a_of_type_Uip.a());
      this.jdField_a_of_type_Uip.a();
    }
    ((uqj)((uqs)urr.a(20)).a(1)).b(this.jdField_a_of_type_Uqr);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
    super.dismiss();
  }
  
  protected void e()
  {
    xgc localxgc = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    if ((localxgc != null) && (localxgc.jdField_b_of_type_Int == 3) && (this.jdField_a_of_type_Xfz.a(localxgc) > 0) && (localxgc != null) && (!localxgc.equals(this.jdField_a_of_type_Xfz.a())))
    {
      this.jdField_a_of_type_Xfz.a(localxgc);
      this.jdField_a_of_type_Xfz.notifyDataSetChanged();
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
    default: 
      return;
    case 2131370858: 
      f();
      wtb.a("0X80076DB");
      dismiss();
      return;
    case 2131370859: 
      wtb.a("0X80076DC");
      g();
      return;
    }
    g();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Xfz != null)
    {
      paramView = (xgc)this.jdField_a_of_type_Xfz.getItem(paramInt);
      if (paramView != null) {
        break label39;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onItemClick error musicInfo is null");
      }
    }
    label39:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Xfz.a(paramView);
        this.jdField_a_of_type_Xfz.notifyDataSetChanged();
        b();
        if (paramInt >= this.jdField_a_of_type_Xfz.a()) {
          break;
        }
        if (paramView.jdField_b_of_type_Int == 0)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramView);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
          if (this.jdField_a_of_type_Boolean) {}
          for (paramAdapterView = "2";; paramAdapterView = "1")
          {
            wta.a("video_edit", "close_music", 0, 0, new String[] { paramAdapterView, "", "", "" });
            wtb.a("0X80076D3");
            return;
          }
        }
        if (paramView.jdField_b_of_type_Int == 1)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramView);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
          if (this.jdField_a_of_type_Boolean) {}
          for (paramAdapterView = "2";; paramAdapterView = "1")
          {
            wta.a("video_edit", "clk_video_sound", 0, 0, new String[] { paramAdapterView, "", "", "" });
            wtb.a("0X80076D4");
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a("608", "3", "2", true);
            return;
          }
        }
      } while (paramView.jdField_b_of_type_Int != 2);
      if (!bdee.g(BaseApplication.getContext()))
      {
        e();
        QQToast.a(BaseApplication.getContext(), 2131695727, 0).a();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "click add qqmusic");
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.c(false);
      d();
      paramAdapterView = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      paramInt = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int;
      if ((paramAdapterView instanceof BaseActivity)) {
        xgb.a((BaseActivity)paramAdapterView, paramInt);
      }
      if (this.jdField_a_of_type_Boolean) {}
      for (paramAdapterView = "2";; paramAdapterView = "1")
      {
        wta.a("video_edit", "add_qqmusic", 0, 0, new String[] { paramAdapterView, "", "", "" });
        wtb.a("0X80076D5");
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a("608", "3", "1", true);
        return;
      }
      if (paramView.jdField_b_of_type_Int != 4) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(xgc.jdField_a_of_type_Xgc);
    } while (this.jdField_a_of_type_Xfm == null);
    this.jdField_a_of_type_Xfm.a(paramView);
    return;
    if (!TextUtils.isEmpty(paramView.jdField_d_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramView);
    a(paramView);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      wta.a("video_edit", "add_music", 0, 0, new String[] { paramAdapterView, "", "", "" });
      wtb.a("0X80076D8", "", "", paramView.jdField_b_of_type_JavaLangString, "");
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a("608", "3", "1", true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog
 * JD-Core Version:    0.7.0.1
 */