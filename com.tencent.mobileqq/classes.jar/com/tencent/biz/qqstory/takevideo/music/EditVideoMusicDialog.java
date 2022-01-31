package com.tencent.biz.qqstory.takevideo.music;

import actj;
import ajya;
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
import bbdj;
import bbdx;
import bbfj;
import bbgu;
import bcql;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MusicConfigInfo;
import com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import stk;
import stx;
import syo;
import syq;
import tbr;
import tbu;
import tbz;
import tca;
import tcz;
import tmo;
import toi;
import vei;
import vej;
import vhm;
import vhy;
import vqu;
import vqx;
import vrb;
import vrc;
import vrd;
import vre;
import vrf;
import vrh;
import vri;
import vrj;
import vrk;
import vyf;
import vzl;

@TargetApi(11)
public class EditVideoMusicDialog
  extends Dialog
  implements View.OnClickListener, AdapterView.OnItemClickListener, stk, syq<tmo, toi>, vri
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
  protected stx a;
  private tbz<tbu> jdField_a_of_type_Tbz = new vrf(this);
  public vqu a;
  private vqx jdField_a_of_type_Vqx;
  public vrh a;
  public vrk a;
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
    super(paramContext, 2131755160);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_a_of_type_AndroidOsHandler = new vrc(this);
    super.requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic = paramEditVideoMusic;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_d_of_type_Boolean = paramBoolean3;
    this.jdField_a_of_type_Vqx = new vqx(paramContext, new vrb(this), this.jdField_a_of_type_AndroidOsHandler);
    a(paramContext);
    paramContext = super.getWindow().getAttributes();
    paramContext.x = 0;
    paramContext.y = 0;
    paramContext.width = -1;
    paramContext.height = vzl.d(getContext());
    paramContext.windowAnimations = 2131755178;
    paramContext.gravity = 83;
    super.getWindow().setBackgroundDrawable(new ColorDrawable());
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "pressCancelBtn");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(this.jdField_a_of_type_Vrk);
    if (this.jdField_a_of_type_Vrk != null)
    {
      this.jdField_a_of_type_Vrk.jdField_d_of_type_Int = this.jdField_d_of_type_Int;
      this.jdField_a_of_type_Vrk.jdField_e_of_type_Int = this.jdField_e_of_type_Int;
      if (this.jdField_a_of_type_Vrk.jdField_b_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        return;
      }
      if (this.jdField_a_of_type_Vrk.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Vrk.g))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(vrk.jdField_b_of_type_Vrk);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(vrk.jdField_b_of_type_Vrk);
  }
  
  private void g()
  {
    int j = 1;
    vrk localvrk = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    int i = j;
    if (localvrk != null)
    {
      i = j;
      if (this.jdField_a_of_type_Vrk != null)
      {
        if ((localvrk.jdField_b_of_type_Int == 3) || (localvrk.jdField_b_of_type_Int == 2)) {
          break label108;
        }
        i = j;
      }
    }
    while ((this.jdField_d_of_type_Boolean) && (i != 0))
    {
      bbdj.a(getContext(), 230).setMessage(ajya.a(2131703792)).setPositiveButton(ajya.a(2131703773), new vre(this)).setNegativeButton(ajya.a(2131703716), new vrd(this)).show();
      return;
      label108:
      i = j;
      if (localvrk.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Vrk.jdField_a_of_type_JavaLangString)) {
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
      vei.a("video_edit", "cut_music", 0, 0, new String[] { str, "", "", "" });
      vej.a("0X80076DA");
      return;
    }
  }
  
  public void a(Context paramContext)
  {
    Object localObject = LayoutInflater.from(paramContext).inflate(2131561305, null);
    super.setContentView((View)localObject);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = (this.jdField_a_of_type_Int / 4);
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject).findViewById(2131370557));
      this.jdField_b_of_type_AndroidViewView = ((View)localObject).findViewById(2131370546);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView = ((MusicHorizontalSeekView)((View)localObject).findViewById(2131370548));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setOnSeekListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131370549));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131375780));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131375779));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370553));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370554));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365641));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131375814);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.b()) {
        break label575;
      }
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)((View)localObject).findViewById(2131370547));
      this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(-1);
      this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
      }
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this);
      this.jdField_c_of_type_AndroidViewView = ((View)localObject).findViewById(2131365252);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_Vrh = new vrh(paramContext, this.jdField_a_of_type_AndroidWidgetGridView, this.jdField_a_of_type_Boolean, a(this.jdField_c_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Vrh);
      this.jdField_a_of_type_Vrh.a(null);
      label340:
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      if (localObject == null)
      {
        EditVideoMusic localEditVideoMusic = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic;
        if (!this.jdField_a_of_type_Boolean) {
          break label616;
        }
        paramContext = vrk.jdField_a_of_type_Vrk;
        label369:
        localEditVideoMusic.a(paramContext);
      }
      this.jdField_a_of_type_Vrk = ((vrk)localObject);
      this.jdField_d_of_type_Int = ((vrk)localObject).jdField_d_of_type_Int;
      this.jdField_e_of_type_Int = ((vrk)localObject).jdField_e_of_type_Int;
      this.jdField_c_of_type_Boolean = vhm.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 512);
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Vqu = new vqu(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams, this.jdField_a_of_type_AndroidOsHandler);
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
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList = vrk.a(getContext());
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      if (i != 0)
      {
        if (!bbfj.d(getContext())) {
          break label628;
        }
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        paramContext = new tmo();
        syo.a().a(paramContext, this);
      }
      return;
      if (this.jdField_a_of_type_Int < 5000)
      {
        this.jdField_a_of_type_Long = (this.jdField_a_of_type_Int / 6);
        break;
      }
      this.jdField_a_of_type_Long = 1000L;
      break;
      ((View)localObject).findViewById(2131365165).getLayoutParams().height = actj.a(138.0F, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a());
      ((View)localObject).findViewById(2131370550).setVisibility(8);
      break label340;
      paramContext = vrk.jdField_b_of_type_Vrk;
      break label369;
    }
    label628:
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    bcql.a(getContext(), ajya.a(2131703771), 0).a();
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = vrj.a(paramString);
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
      if ((localObject != null) && (paramString.equals(((vrk)localObject).jdField_d_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(str);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        getContext().getSharedPreferences("VideoMusicCache", 0).edit().putString(((vrk)localObject).jdField_a_of_type_JavaLangString, str).commit();
      }
      vei.a("edit_video", "music_download_success", 0, 0, new String[] { "", "", "", "" });
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        long l = ((Long)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onDownloadFinish errCode = " + paramInt + ", name = " + vyf.b(paramString) + ", downloadTime = " + (System.currentTimeMillis() - l) + ", fileSize = " + vyf.a(str) + new StringBuilder().append(", url = ").append(paramString).toString());
      }
      return;
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      if ((localObject != null) && (paramString != null) && (paramString.equals(((vrk)localObject).jdField_d_of_type_JavaLangString)))
      {
        if (paramInt != 6)
        {
          localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7, getContext().getResources().getString(2131698328));
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
        }
        f();
      }
      vei.a("edit_video", "music_download_failed", 0, 0, new String[] { String.valueOf(paramInt), "", "", "" });
      vej.a("0X80076D9");
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
  
  public void a(tmo paramtmo, toi paramtoi, ErrorMessage paramErrorMessage)
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
    for (paramtmo = "null";; paramtmo = paramErrorMessage.getErrorMessage())
    {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, paramtmo);
      vei.a("edit_video", "music_list_time", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long), "", "", "" });
      if ((paramErrorMessage == null) || (!paramErrorMessage.isFail())) {
        break;
      }
      paramtmo = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
      paramtmo.obj = ("onCmdRespond error = " + paramErrorMessage.getErrorMessage());
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramtmo);
      vei.a("edit_video", "music_list_failed", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    paramtmo = paramtoi.a;
    int j = paramtmo.music_config.size();
    paramtoi = new ArrayList(j);
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        paramtoi.add(new vrk((qqstory_struct.MusicConfigInfo)paramtmo.music_config.get(i)));
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "GetMusicConfigResponse size = " + j);
      }
    }
    for (;;)
    {
      vei.a("edit_video", "music_list_count", 0, 0, new String[] { String.valueOf(j), "", "", "" });
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList = paramtoi;
      vrk.a(getContext(), paramtoi);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onCmdRespond data is NULL!!!!!");
      }
    }
  }
  
  public void a(vrk paramvrk)
  {
    String str = paramvrk.jdField_d_of_type_JavaLangString;
    Object localObject = paramvrk.g;
    if ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramvrk = (vrk)localObject;
      if (!vyf.e((String)localObject)) {
        paramvrk = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      }
      localObject = paramvrk;
      if (!vyf.e(paramvrk)) {
        localObject = vrj.a(str);
      }
      if (!vyf.e((String)localObject)) {
        break label171;
      }
      if ((this.jdField_a_of_type_Stx != null) && (this.jdField_a_of_type_Stx.a()))
      {
        bbdx.d(this.jdField_a_of_type_Stx.a());
        this.jdField_a_of_type_Stx.a();
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
    if (!bbfj.g(BaseApplication.getContext()))
    {
      e();
      bcql.a(BaseApplication.getContext(), 2131695569, 0).a();
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject);
    if ((this.jdField_a_of_type_Stx != null) && (this.jdField_a_of_type_Stx.a()))
    {
      bbdx.d(this.jdField_a_of_type_Stx.a());
      this.jdField_a_of_type_Stx.a();
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
    vrk localvrk = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    vhy localvhy;
    if (localvrk != null)
    {
      localvhy = (vhy)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_Vhm.a(vhy.class);
      if (localvhy != null) {
        if ((localvrk.jdField_b_of_type_Int != 2) && (localvrk.jdField_b_of_type_Int != 3) && (localvrk.jdField_b_of_type_Int != 0)) {
          break label88;
        }
      }
    }
    label88:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localvhy.a(paramBoolean);
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
      this.jdField_c_of_type_AndroidWidgetTextView.setText(vrj.a(paramInt1, false));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(vrj.a(i, false));
      return;
      i = j;
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    vrk localvrk = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    if (localvrk != null)
    {
      paramInt2 = localvrk.jdField_f_of_type_Int;
      localvrk.jdField_d_of_type_Int = ((int)(paramInt2 * (paramInt3 / paramInt1)));
      localvrk.jdField_e_of_type_Int = (localvrk.jdField_d_of_type_Int + this.jdField_a_of_type_Int);
      if ((localvrk.jdField_e_of_type_Int > paramInt2) && (paramInt2 > this.jdField_a_of_type_Int))
      {
        localvrk.jdField_e_of_type_Int = paramInt2;
        localvrk.jdField_d_of_type_Int = (paramInt2 - this.jdField_a_of_type_Int);
      }
      b(localvrk.jdField_d_of_type_Int, localvrk.jdField_e_of_type_Int);
    }
  }
  
  public void b(vrk paramvrk)
  {
    if ((!TextUtils.isEmpty(paramvrk.jdField_d_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramvrk.g)))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramvrk.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramvrk);
    a(paramvrk);
    vej.a("0X80076D6");
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
    this.jdField_a_of_type_Vqx.a();
    if ((this.jdField_a_of_type_Stx != null) && (this.jdField_a_of_type_Stx.a()))
    {
      bbdx.d(this.jdField_a_of_type_Stx.a());
      this.jdField_a_of_type_Stx.a();
    }
    ((tbr)((tca)tcz.a(20)).a(1)).b(this.jdField_a_of_type_Tbz);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
    super.dismiss();
  }
  
  protected void e()
  {
    vrk localvrk = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    if ((localvrk != null) && (localvrk.jdField_b_of_type_Int == 3) && (this.jdField_a_of_type_Vrh.a(localvrk) > 0) && (localvrk != null) && (!localvrk.equals(this.jdField_a_of_type_Vrh.a())))
    {
      this.jdField_a_of_type_Vrh.a(localvrk);
      this.jdField_a_of_type_Vrh.notifyDataSetChanged();
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
    case 2131370553: 
      f();
      vej.a("0X80076DB");
      dismiss();
      return;
    case 2131370554: 
      vej.a("0X80076DC");
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
    if (this.jdField_a_of_type_Vrh != null)
    {
      paramView = (vrk)this.jdField_a_of_type_Vrh.getItem(paramInt);
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
        this.jdField_a_of_type_Vrh.a(paramView);
        this.jdField_a_of_type_Vrh.notifyDataSetChanged();
        b();
        if (paramInt >= this.jdField_a_of_type_Vrh.a()) {
          break;
        }
        if (paramView.jdField_b_of_type_Int == 0)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramView);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
          if (this.jdField_a_of_type_Boolean) {}
          for (paramAdapterView = "2";; paramAdapterView = "1")
          {
            vei.a("video_edit", "close_music", 0, 0, new String[] { paramAdapterView, "", "", "" });
            vej.a("0X80076D3");
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
            vei.a("video_edit", "clk_video_sound", 0, 0, new String[] { paramAdapterView, "", "", "" });
            vej.a("0X80076D4");
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a("608", "3", "2", true);
            return;
          }
        }
      } while (paramView.jdField_b_of_type_Int != 2);
      if (!bbfj.g(BaseApplication.getContext()))
      {
        e();
        bcql.a(BaseApplication.getContext(), 2131695569, 0).a();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "click add qqmusic");
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.c(false);
      d();
      paramAdapterView = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      paramInt = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int;
      if ((paramAdapterView instanceof BaseActivity)) {
        vrj.a((BaseActivity)paramAdapterView, paramInt);
      }
      if (this.jdField_a_of_type_Boolean) {}
      for (paramAdapterView = "2";; paramAdapterView = "1")
      {
        vei.a("video_edit", "add_qqmusic", 0, 0, new String[] { paramAdapterView, "", "", "" });
        vej.a("0X80076D5");
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a("608", "3", "1", true);
        return;
      }
      if (paramView.jdField_b_of_type_Int != 4) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(vrk.jdField_a_of_type_Vrk);
    } while (this.jdField_a_of_type_Vqu == null);
    this.jdField_a_of_type_Vqu.a(paramView);
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
      vei.a("video_edit", "add_music", 0, 0, new String[] { paramAdapterView, "", "", "" });
      vej.a("0X80076D8", "", "", paramView.jdField_b_of_type_JavaLangString, "");
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a("608", "3", "1", true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog
 * JD-Core Version:    0.7.0.1
 */