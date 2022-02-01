import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.13;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.17;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.21;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.24;
import com.tencent.mobileqq.nearby.now.view.widget.LikeAniView;
import com.tencent.mobileqq.nearby.now.view.widget.RoundRelativeLayout;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.now.ilive_short_video_label.FeedInfo;
import com.tencent.pb.now.ilive_short_video_label.GetShortVideoVideoLabelRsp;
import com.tencent.pb.now.ilive_short_video_label.VideoInfo;
import com.tencent.pb.now.ilive_short_video_label.VideoStatus;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class axop
{
  public static int a;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f;
  public static final String g;
  private static int jdField_m_of_type_Int = -15550475;
  private static int jdField_n_of_type_Int = -1;
  private final long jdField_a_of_type_Long = 500L;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public View a;
  axjb jdField_a_of_type_Axjb = new axow(this);
  private axnd jdField_a_of_type_Axnd;
  private axpt jdField_a_of_type_Axpt = new axpt(this, null);
  private axpu jdField_a_of_type_Axpu = new axpu(this, null);
  private axpv jdField_a_of_type_Axpv = new axpv(this, null);
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  public QQAppInterface a;
  VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = new VideoData();
  String jdField_a_of_type_JavaLangString;
  public volatile boolean a;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  public View b;
  String jdField_b_of_type_JavaLangString;
  public volatile boolean b;
  private int jdField_c_of_type_Int = 1;
  private long jdField_c_of_type_Long;
  boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 6;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 7;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = -1;
  private String jdField_i_of_type_JavaLangString;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private String jdField_j_of_type_JavaLangString;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  private boolean jdField_m_of_type_Boolean = true;
  private boolean jdField_n_of_type_Boolean = true;
  private boolean o = true;
  private boolean p;
  
  static
  {
    jdField_a_of_type_Int = 2;
    jdField_c_of_type_JavaLangString = anni.a(2131707023);
    jdField_d_of_type_JavaLangString = anni.a(2131707011);
    jdField_e_of_type_JavaLangString = anni.a(2131707003);
    jdField_f_of_type_JavaLangString = anni.a(2131707012);
    jdField_g_of_type_JavaLangString = anni.a(2131707022);
  }
  
  public axop(View paramView, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Axjb);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new axoq(this));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewView.getContext(), new axoz(this));
    this.jdField_a_of_type_AndroidViewGestureDetector.setOnDoubleTapListener(new axpl(this));
    g();
    h();
  }
  
  private AnimatorSet a(View paramView)
  {
    AnimatorSet localAnimatorSet1 = new AnimatorSet();
    AnimatorSet localAnimatorSet2 = new AnimatorSet();
    localAnimatorSet2.playTogether(new Animator[] { ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.0F, 1.0F }), ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.0F, 1.0F }), ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F }) });
    localAnimatorSet2.setDuration(200L);
    AnimatorSet localAnimatorSet3 = new AnimatorSet();
    localAnimatorSet3.playTogether(new Animator[] { ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F }) });
    localAnimatorSet3.setDuration(350L);
    localAnimatorSet1.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimatorSet1.playSequentially(new Animator[] { localAnimatorSet3, localAnimatorSet2 });
    return localAnimatorSet1;
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView = paramView.getBackground();
    if (paramView != null)
    {
      paramView.setColorFilter(new LightingColorFilter(-16777216, paramInt));
      paramView.invalidateSelf();
    }
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidViewView.findViewById(2131367877).setOnClickListener(new axpn(this));
    this.jdField_b_of_type_AndroidViewView.findViewById(2131371705).setOnClickListener(new axpo(this));
    this.jdField_b_of_type_AndroidViewView.findViewById(2131366918).setOnClickListener(new axpp(this));
    this.jdField_b_of_type_AndroidViewView.findViewById(2131364554).setOnClickListener(new axpq(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131364754).setOnClickListener(new axpr(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131369823).setOnClickListener(new axps(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131377357).setOnClickListener(new axor(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131371284).setOnClickListener(new axos(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131377890).setOnClickListener(new axot(this));
  }
  
  private void e(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("feeds_id", paramString);
      paramString = localJSONObject.toString();
      localSharedPreferences.edit().putString("nearby_now_delete_success_js_param", paramString).commit();
      return;
    }
    catch (JSONException paramString) {}
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { a(this.jdField_a_of_type_AndroidViewView.findViewById(2131377887)) });
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidViewView.findViewById(2131364754).setOnTouchListener(new axpg(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131369823).setOnTouchListener(new axph(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131377357).setOnTouchListener(new axpi(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131371284).setOnTouchListener(new axpj(this));
  }
  
  private void i()
  {
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371705)).setTextColor(Color.parseColor("#000000"));
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366158)).setTextColor(Color.parseColor("#bbbbbb"));
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366892)).setTextColor(jdField_n_of_type_Int);
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366917)).setTextColor(jdField_n_of_type_Int);
    a(this.jdField_b_of_type_AndroidViewView.findViewById(2131366927), jdField_n_of_type_Int);
    this.jdField_b_of_type_Int = jdField_m_of_type_Int;
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidViewView.findViewById(2131366915).setBackgroundColor(jdField_m_of_type_Int);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131366916).setBackgroundDrawable(null);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.findViewById(2131367856).setBackgroundColor(-1);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131364556).setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131364555).setVisibility(0);
      View localView = this.jdField_b_of_type_AndroidViewView.findViewById(2131367856).findViewById(2131363523);
      if (localView.getVisibility() == 8) {
        localView.setVisibility(0);
      }
      return;
      a(this.jdField_b_of_type_AndroidViewView.findViewById(2131366916), jdField_m_of_type_Int);
    }
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_AndroidViewView.findViewById(2131366927) == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.findViewById(2131366916).clearAnimation();
    this.jdField_b_of_type_AndroidViewView.findViewById(2131366912).clearAnimation();
    int i1 = (int)mue.a(this.jdField_b_of_type_AndroidViewView.getContext(), 20.0F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView.findViewById(2131366892), "translationY", new float[] { 0.0F, -i1 });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView.findViewById(2131366917), "translationY", new float[] { 0.0F, -i1 });
    Object localObject = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView.findViewById(2131366927), "translationY", new float[] { i1, 0.0F });
    this.jdField_b_of_type_AndroidViewView.findViewById(2131366927).setVisibility(0);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator1, localObjectAnimator2 });
    localAnimatorSet.setDuration(500L);
    localAnimatorSet.start();
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView.findViewById(2131366918), "scaleX", new float[] { 1.0F, 0.75F, 0.5F, 0.2F, 0.0F });
    localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView.findViewById(2131366918), "scaleY", new float[] { 1.0F, 0.75F, 0.5F, 0.25F, 0.0F });
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    ((AnimatorSet)localObject).addListener(new axpm(this));
    ((AnimatorSet)localObject).setDuration(500L);
    ((AnimatorSet)localObject).setStartDelay(800L);
    ((AnimatorSet)localObject).start();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PlayOperationViewModel", 2, "initCommentsWidget:mVideoData=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PlayOperationViewModel", 2, "initCommentsWidget:mRoomid=" + this.jdField_h_of_type_Int + "isHasVideoLabel=" + this.jdField_l_of_type_Boolean);
    }
    this.jdField_h_of_type_Int = 0;
    a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_Long);
    c(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_f_of_type_JavaLangString);
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (!this.jdField_h_of_type_Boolean)) {
      this.jdField_b_of_type_AndroidViewView.findViewById(2131378826).setVisibility(0);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ImageView localImageView;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localImageView = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131362288);
      localImageView.setVisibility(0);
      if (paramInt2 != 1) {
        break label63;
      }
      localImageView.setBackgroundDrawable(localImageView.getResources().getDrawable(2130845500));
    }
    while ((paramInt2 == 255) || (paramInt2 == 0))
    {
      localImageView.setVisibility(8);
      return;
      label63:
      localImageView.setBackgroundDrawable(localImageView.getResources().getDrawable(2130845498));
    }
    localImageView.setVisibility(0);
  }
  
  public void a(long paramLong)
  {
    if (paramLong <= 0L)
    {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377877)).setText(anni.a(2131707021));
      return;
    }
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377877)).setText(axln.b(paramLong));
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
    ((RoundRelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131366915)).a(16);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131366915).requestLayout();
    ((RoundRelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131366914)).a(16);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131366914).requestLayout();
    e();
  }
  
  public void a(axnd paramaxnd)
  {
    this.jdField_a_of_type_Axnd = paramaxnd;
  }
  
  public void a(VideoData paramVideoData)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.i("PlayOperationViewModel", 2, "updateShowInfo:mVideoData=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData);
    }
    this.jdField_j_of_type_JavaLangString = paramVideoData.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
    if (paramVideoData.jdField_a_of_type_Int == 1)
    {
      a(false);
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramVideoData.jdField_e_of_type_JavaLangString;
    this.jdField_f_of_type_Long = paramVideoData.jdField_b_of_type_Long;
    this.jdField_l_of_type_Int = paramVideoData.jdField_c_of_type_Int;
    if (paramVideoData.jdField_g_of_type_Long == paramVideoData.jdField_c_of_type_Long)
    {
      b(paramVideoData.jdField_i_of_type_JavaLangString);
      d(paramVideoData.jdField_h_of_type_JavaLangString);
      this.jdField_c_of_type_Long = paramVideoData.jdField_c_of_type_Long;
      this.jdField_b_of_type_Long = paramVideoData.jdField_a_of_type_Long;
      b(paramVideoData.jdField_d_of_type_Int);
      a(paramVideoData.jdField_e_of_type_Int, paramVideoData.jdField_f_of_type_Int);
      if (paramVideoData.jdField_a_of_type_Int != 1) {
        break label305;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int != 3) {
        break label344;
      }
      bool1 = true;
      label174:
      b(bool1);
      if (paramVideoData.jdField_a_of_type_Int != 1) {
        break label349;
      }
      bool1 = true;
      label189:
      e(bool1);
      if (paramVideoData.jdField_a_of_type_Int != 4) {
        break label354;
      }
      bool1 = true;
      label204:
      d(bool1);
      h(paramVideoData.jdField_a_of_type_Boolean);
      if (TextUtils.isEmpty(paramVideoData.jdField_e_of_type_JavaLangString)) {
        break label359;
      }
    }
    label305:
    label344:
    label349:
    label354:
    label359:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      c(bool1);
      a(paramVideoData.jdField_j_of_type_Int);
      c();
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_Int == 4) && (this.o)) {}
      this.o = false;
      return;
      b(paramVideoData.jdField_f_of_type_JavaLangString);
      d(paramVideoData.jdField_g_of_type_JavaLangString);
      this.jdField_c_of_type_Long = paramVideoData.jdField_a_of_type_Long;
      this.jdField_b_of_type_Long = paramVideoData.jdField_c_of_type_Long;
      break;
      if (paramVideoData.jdField_m_of_type_Int == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        g(bool1);
        f(paramVideoData.jdField_b_of_type_Boolean);
        d(paramVideoData.jdField_b_of_type_Int);
        break;
      }
      bool1 = false;
      break label174;
      bool1 = false;
      break label189;
      bool1 = false;
      break label204;
    }
  }
  
  public void a(ilive_short_video_label.GetShortVideoVideoLabelRsp paramGetShortVideoVideoLabelRsp)
  {
    if (paramGetShortVideoVideoLabelRsp == null) {
      return;
    }
    this.jdField_h_of_type_Int = paramGetShortVideoVideoLabelRsp.video_status.root_room_id.get();
    this.jdField_k_of_type_Int = paramGetShortVideoVideoLabelRsp.type.get();
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380691);
    RoundRelativeLayout localRoundRelativeLayout = (RoundRelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377890);
    localRoundRelativeLayout.a(10);
    localRoundRelativeLayout.requestLayout();
    switch (this.jdField_k_of_type_Int)
    {
    default: 
      localRoundRelativeLayout.setVisibility(8);
      if (this.jdField_k_of_type_Int != 0) {
        break;
      }
    }
    for (boolean bool = false;; bool = true)
    {
      this.jdField_l_of_type_Boolean = bool;
      return;
      this.jdField_a_of_type_Axpt.jdField_a_of_type_Int = paramGetShortVideoVideoLabelRsp.video_status.root_room_id.get();
      localTextView.setText(anni.a(2131707001));
      localRoundRelativeLayout.setBackgroundResource(2130845503);
      localRoundRelativeLayout.setVisibility(0);
      break;
      this.jdField_a_of_type_Axpv.jdField_a_of_type_JavaLangString = paramGetShortVideoVideoLabelRsp.feed_info.feed_id.get().toStringUtf8();
      this.jdField_a_of_type_Axpv.jdField_b_of_type_JavaLangString = paramGetShortVideoVideoLabelRsp.feed_info.topic.get();
      this.jdField_a_of_type_Axpv.jdField_c_of_type_JavaLangString = paramGetShortVideoVideoLabelRsp.feed_info.url.get();
      localTextView.setText(this.jdField_a_of_type_Axpv.jdField_b_of_type_JavaLangString);
      localRoundRelativeLayout.setBackgroundResource(2130845505);
      localRoundRelativeLayout.setVisibility(0);
      break;
      this.jdField_a_of_type_Axpu.jdField_a_of_type_JavaLangString = paramGetShortVideoVideoLabelRsp.video_info.url.get();
      this.jdField_a_of_type_Axpu.jdField_b_of_type_JavaLangString = paramGetShortVideoVideoLabelRsp.video_info.cover_url.get();
      localTextView.setText(anni.a(2131707004));
      localRoundRelativeLayout.setBackgroundResource(2130845506);
      localRoundRelativeLayout.setVisibility(0);
      break;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_i_of_type_JavaLangString = paramString;
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366158)).setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = 8;
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int == 1))
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131372034).setVisibility(8);
      return;
    }
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372034);
    if (paramBoolean) {
      i1 = 0;
    }
    localView.setVisibility(i1);
  }
  
  public boolean a(long paramLong)
  {
    new axks(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramLong, this.jdField_j_of_type_JavaLangString, new axpk(this));
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Axnd = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Axjb);
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    a(axln.c(this.jdField_f_of_type_Int) + anni.a(2131707019));
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PlayOperationViewModel", 2, "setCurrentAnchorUin,currentAnchorUin:" + paramLong);
    }
    this.jdField_d_of_type_Long = paramLong;
  }
  
  public void b(View paramView)
  {
    if (!this.jdField_l_of_type_Boolean) {
      return;
    }
    new axlq().h("video").i("playpage_label_click").b().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ThreadManagerV2.excute(new PlayOperationViewModel.13(this, (axby)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
    switch (this.jdField_k_of_type_Int)
    {
    case 3: 
    default: 
      return;
    case 1: 
      localObject = String.format("nowmqqapi://now/openroom?first=2&roomid=%s&roomtype=0&fromid=qq_smallvideo", new Object[] { Integer.valueOf(this.jdField_a_of_type_Axpt.jdField_a_of_type_Int) });
      bgng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), (String)localObject).a();
      new axlq().h("video").i("playpage_live_click").b().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    Object localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_Axpv.jdField_c_of_type_JavaLangString);
    paramView.getContext().startActivity((Intent)localObject);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_b_of_type_AndroidViewView != null) {
      axlp.a().a((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131367877), paramString, this.jdField_b_of_type_AndroidViewView.getResources().getDrawable(2130845420), this.jdField_b_of_type_AndroidViewView.getResources().getDrawable(2130845420), null, true);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    if ((this.jdField_g_of_type_Boolean) || (this.jdField_h_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363611).setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363611).setAlpha(1.0F);
  }
  
  public void c(int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
  }
  
  public void c(View paramView)
  {
    if (!nmd.a(this.jdField_a_of_type_AndroidViewView.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidViewView.getContext(), 1, anni.a(2131707008), 1).a();
      return;
    }
    this.jdField_k_of_type_Boolean = true;
    f();
    paramView = new axks(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    VideoData localVideoData;
    int i1;
    int i2;
    if (!this.jdField_d_of_type_Boolean)
    {
      localVideoData = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372034);
      i1 = localView.getWidth() / 2;
      i2 = localView.getHeight() / 2;
      if ((i1 != 0) && (i2 != 0)) {
        break label252;
      }
      i1 = mue.a(this.jdField_a_of_type_AndroidViewView.getContext()) / 2;
      i2 = mue.b(this.jdField_a_of_type_AndroidViewView.getContext()) / 2;
    }
    label252:
    for (;;)
    {
      if ((localVideoData != null) && (localVideoData.jdField_a_of_type_Int != 6)) {
        ((LikeAniView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369822)).a(i1, i2);
      }
      paramView.a(this.jdField_j_of_type_JavaLangString, new axou(this, localVideoData), null);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "new_thing", "clk_like", 0, 0, "", "", "", "2");
      return;
      this.jdField_m_of_type_Boolean = true;
      localVideoData = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
      paramView.b(this.jdField_j_of_type_JavaLangString, new axov(this, localVideoData), null);
      return;
    }
  }
  
  public void c(String paramString) {}
  
  public void c(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  public void d()
  {
    i();
    this.jdField_n_of_type_Boolean = false;
    e(1);
  }
  
  public void d(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
    if (paramInt > 0)
    {
      if (this.jdField_j_of_type_Int == 1) {
        if (this.jdField_d_of_type_Boolean) {
          ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377887)).setImageResource(2130845466);
        }
      }
      for (;;)
      {
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377886)).setText(axln.b(paramInt));
        return;
        ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377887)).setImageResource(2130845484);
        continue;
        if (this.jdField_d_of_type_Boolean) {
          ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377887)).setImageResource(2130845466);
        } else {
          ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377887)).setImageResource(2130845465);
        }
      }
    }
    if (this.jdField_j_of_type_Int == 1) {
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377887)).setImageResource(2130845484);
    }
    for (;;)
    {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377886)).setText(anni.a(2131707014));
      return;
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377887)).setImageResource(2130845465);
    }
  }
  
  public void d(View paramView)
  {
    ((axby)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)).d.put(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_Long + "", Integer.valueOf(1));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("&from=3");
    int i1 = 3;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals("" + this.jdField_c_of_type_Long)) {
      i1 = 2;
    }
    ((StringBuilder)localObject).append("&mode=" + i1);
    localObject = "mqq://card/show_pslcard/?uin=" + this.jdField_c_of_type_Long + "&card_type=nearby" + ((StringBuilder)localObject).toString() + "&now_id=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_b_of_type_Long + "&now_user_type=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_c_of_type_Int;
    paramView.getContext().startActivity(new Intent(paramView.getContext(), JumpActivity.class).setData(Uri.parse((String)localObject)));
    new axlq().h("video").i("playpage_post_click").b().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ThreadManagerV2.excute(new PlayOperationViewModel.17(this, (axby)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "new_thing", "clk_card", 0, 0, "", "", "", "2");
  }
  
  public void d(String paramString)
  {
    this.jdField_h_of_type_JavaLangString = paramString;
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371705)).setText(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
    View localView = this.jdField_b_of_type_AndroidViewView.findViewById(2131378826);
    if ((this.jdField_g_of_type_Boolean) || (this.jdField_h_of_type_Boolean)) {}
    for (int i1 = 8;; i1 = 0)
    {
      localView.setVisibility(i1);
      return;
    }
  }
  
  public void e(int paramInt)
  {
    int i1 = -1;
    this.jdField_j_of_type_Int = paramInt;
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131363611);
    if (this.jdField_j_of_type_Int == 0)
    {
      paramInt = 2130845542;
      ((View)localObject).setBackgroundResource(paramInt);
      localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377878);
      if (this.jdField_j_of_type_Int != 0) {
        break label252;
      }
      paramInt = 2130845463;
      label59:
      ((ImageView)localObject).setImageResource(paramInt);
      localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377892);
      if (this.jdField_j_of_type_Int != 0) {
        break label259;
      }
      paramInt = 2130845469;
      label89:
      ((ImageView)localObject).setImageResource(paramInt);
      localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377889);
      if (this.jdField_j_of_type_Int != 0) {
        break label266;
      }
      paramInt = 2130845467;
      label119:
      ((ImageView)localObject).setImageResource(paramInt);
      localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377877);
      if (this.jdField_j_of_type_Int != 0) {
        break label273;
      }
      paramInt = -1;
      label147:
      ((TextView)localObject).setTextColor(paramInt);
      localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377886);
      if (this.jdField_j_of_type_Int != 0) {
        break label279;
      }
      paramInt = -1;
      label175:
      ((TextView)localObject).setTextColor(paramInt);
      localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377891);
      if (this.jdField_j_of_type_Int != 0) {
        break label285;
      }
      paramInt = -1;
      label203:
      ((TextView)localObject).setTextColor(paramInt);
      localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377888);
      if (this.jdField_j_of_type_Int != 0) {
        break label291;
      }
    }
    label259:
    label266:
    label273:
    label279:
    label285:
    label291:
    for (paramInt = i1;; paramInt = -16777216)
    {
      ((TextView)localObject).setTextColor(paramInt);
      d(this.jdField_g_of_type_Int);
      return;
      paramInt = 2130845543;
      break;
      label252:
      paramInt = 2130845464;
      break label59;
      paramInt = 2130845470;
      break label89;
      paramInt = 2130845468;
      break label119;
      paramInt = -16777216;
      break label147;
      paramInt = -16777216;
      break label175;
      paramInt = -16777216;
      break label203;
    }
  }
  
  public void e(View paramView) {}
  
  public void e(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    View localView = this.jdField_b_of_type_AndroidViewView.findViewById(2131378826);
    if ((this.jdField_g_of_type_Boolean) || (this.jdField_h_of_type_Boolean)) {}
    for (int i1 = 8;; i1 = 0)
    {
      localView.setVisibility(i1);
      return;
    }
  }
  
  public void f(int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidViewView == null) || (!this.jdField_n_of_type_Boolean)) {}
    View localView;
    Object localObject;
    label668:
    do
    {
      return;
      localView = this.jdField_b_of_type_AndroidViewView.findViewById(2131367856).findViewById(2131363523);
      if ((paramInt > 10) && (paramInt < 70))
      {
        float f1 = (paramInt - 10) / 60.0F;
        localObject = new ArgbEvaluator();
        paramInt = ((Integer)((ArgbEvaluator)localObject).evaluate(f1, Integer.valueOf(-1), Integer.valueOf(-16777216))).intValue();
        int i1 = ((Integer)((ArgbEvaluator)localObject).evaluate(f1, Integer.valueOf(-1), Integer.valueOf(-4473925))).intValue();
        int i2 = ((Integer)((ArgbEvaluator)localObject).evaluate(f1, Integer.valueOf(-637534209), Integer.valueOf(jdField_m_of_type_Int))).intValue();
        ((Integer)((ArgbEvaluator)localObject).evaluate(f1, Integer.valueOf(jdField_m_of_type_Int), Integer.valueOf(-1))).intValue();
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371705)).setTextColor(paramInt);
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366158)).setTextColor(i1);
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366892)).setTextColor(jdField_n_of_type_Int);
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366917)).setTextColor(jdField_n_of_type_Int);
        a(this.jdField_b_of_type_AndroidViewView.findViewById(2131366927), jdField_n_of_type_Int);
        this.jdField_b_of_type_Int = i2;
        if (!this.jdField_c_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidViewView.findViewById(2131366915).setBackgroundColor(jdField_m_of_type_Int);
          this.jdField_b_of_type_AndroidViewView.findViewById(2131366916).setBackgroundDrawable(null);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidViewView.findViewById(2131367856).setBackgroundColor(Color.parseColor("#ffffff"));
          this.jdField_b_of_type_AndroidViewView.findViewById(2131367856).getBackground().setAlpha((int)(255.0F * f1));
          this.jdField_b_of_type_AndroidViewView.findViewById(2131364556).setAlpha(1.0F - f1);
          this.jdField_b_of_type_AndroidViewView.findViewById(2131364555).setAlpha(f1);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131377890).setVisibility(8);
          if (localView.getVisibility() != 0) {
            break;
          }
          localView.setVisibility(8);
          return;
          a(this.jdField_b_of_type_AndroidViewView.findViewById(2131366916), jdField_m_of_type_Int);
        }
      }
      if (paramInt <= 10)
      {
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371705)).setTextColor(Color.parseColor("#ffffff"));
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366158)).setTextColor(Color.parseColor("#b3ffffff"));
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366892)).setTextColor(jdField_n_of_type_Int);
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366917)).setTextColor(jdField_n_of_type_Int);
        a(this.jdField_b_of_type_AndroidViewView.findViewById(2131366927), jdField_n_of_type_Int);
        this.jdField_b_of_type_Int = -637534209;
        if (!this.jdField_c_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidViewView.findViewById(2131366915).setBackgroundColor(jdField_m_of_type_Int);
          this.jdField_b_of_type_AndroidViewView.findViewById(2131366916).setBackgroundDrawable(null);
          this.jdField_b_of_type_AndroidViewView.findViewById(2131367856).setBackgroundResource(2130845544);
          this.jdField_b_of_type_AndroidViewView.findViewById(2131364556).setAlpha(1.0F);
          this.jdField_b_of_type_AndroidViewView.findViewById(2131364555).setAlpha(0.0F);
          if (localView.getVisibility() == 0) {
            localView.setVisibility(8);
          }
          localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377890);
          if (!this.jdField_l_of_type_Boolean) {
            break label668;
          }
        }
        for (paramInt = 0;; paramInt = 8)
        {
          localView.setVisibility(paramInt);
          return;
          a(this.jdField_b_of_type_AndroidViewView.findViewById(2131366916), jdField_m_of_type_Int);
          break;
        }
      }
    } while (paramInt < 70);
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371705)).setTextColor(Color.parseColor("#000000"));
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366158)).setTextColor(Color.parseColor("#bbbbbb"));
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366892)).setTextColor(jdField_n_of_type_Int);
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366917)).setTextColor(jdField_n_of_type_Int);
    a(this.jdField_b_of_type_AndroidViewView.findViewById(2131366927), jdField_n_of_type_Int);
    this.jdField_b_of_type_Int = jdField_m_of_type_Int;
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidViewView.findViewById(2131366915).setBackgroundColor(jdField_m_of_type_Int);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131366916).setBackgroundDrawable(null);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.findViewById(2131367856).setBackgroundColor(-1);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131364556).setAlpha(0.0F);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131364555).setAlpha(1.0F);
      if (localView.getVisibility() != 8) {
        break;
      }
      localView.setVisibility(0);
      return;
      localObject = this.jdField_b_of_type_AndroidViewView.findViewById(2131366916).getBackground();
      if (localObject != null)
      {
        ((Drawable)localObject).setColorFilter(new LightingColorFilter(-16777216, jdField_m_of_type_Int));
        ((Drawable)localObject).invalidateSelf();
      }
    }
  }
  
  public void f(View paramView)
  {
    Object localObject = new HashMap();
    paramView = "";
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_Int == 4) {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaUtilArrayList.get(0) == null) {}
    }
    for (paramView = ((axka)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString;; paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_c_of_type_JavaLangString)
    {
      ((Map)localObject).put("record_title", this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_JavaLangString);
      ((Map)localObject).put("id", this.jdField_j_of_type_JavaLangString);
      ((Map)localObject).put("anchor_nick_name", this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_JavaLangString);
      ((Map)localObject).put("feed_type", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_Int));
      ((Map)localObject).put("recorder_nick_name", this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_h_of_type_JavaLangString);
      ((Map)localObject).put("roomName", this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_JavaLangString);
      ((Map)localObject).put("bNewQZone", Boolean.valueOf(false));
      ((Map)localObject).put("source", Integer.valueOf(6));
      ((Map)localObject).put("play_operatro_view_model", this);
      ((Map)localObject).put("anchor_uin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Long));
      ((Map)localObject).put("record_uin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_c_of_type_Long));
      String str1 = "https://now.qq.com/h5/view_record.html?_wv=1&_bid=2424&from=6&feeds_id=" + this.jdField_j_of_type_JavaLangString;
      String str2 = anni.a(2131707018);
      localObject = anni.a(2131707016);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_JavaLangString)) {
        localObject = "“「" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_JavaLangString + "」”" + anni.a(2131707013);
      }
      axla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidViewView.getContext(), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Long), "", str1, str2, (String)localObject, paramView, paramView, this.jdField_a_of_type_ComTencentImageURLDrawable, new axox(this));
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidViewView.findViewById(2131377886).setSelected(this.jdField_d_of_type_Boolean);
  }
  
  public void g(View paramView)
  {
    if (!axei.a(paramView.getContext()))
    {
      QQToast.a(paramView.getContext(), 0, paramView.getContext().getResources().getString(2131693946), 0).a();
      return;
    }
    paramView = new axks(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_e_of_type_Boolean)
    {
      paramView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_Long, this.jdField_f_of_type_Long, this.jdField_l_of_type_Int, 11, false, new axoy(this));
      return;
    }
    this.p = true;
    paramView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_Long, this.jdField_f_of_type_Long, this.jdField_l_of_type_Int, 11, true, new axpa(this));
  }
  
  public void g(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void h(View paramView)
  {
    new axlq().h("video").i("playpage_more_click").b().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ThreadManagerV2.excute(new PlayOperationViewModel.21(this, (axby)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
    paramView = (BaseActivity)this.jdField_a_of_type_AndroidViewView.getContext();
    bkho localbkho = bkho.a(paramView);
    if (!this.jdField_f_of_type_Boolean) {
      localbkho.a(2131716603, 1);
    }
    for (;;)
    {
      localbkho.c(2131690582);
      localbkho.a(new axpb(this, paramView, localbkho));
      localbkho.a(new axpf(this));
      localbkho.show();
      this.jdField_b_of_type_Boolean = true;
      return;
      localbkho.a(anni.a(2131706997), 1);
    }
  }
  
  public void h(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.i("PlayOperationViewModel", 2, "is follow? " + paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PlayOperationViewModel", 2, "is Mine? " + this.jdField_f_of_type_Boolean);
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      if ((this.jdField_e_of_type_Boolean) || (this.jdField_f_of_type_Boolean)) {
        this.jdField_b_of_type_AndroidViewView.findViewById(2131366918).setVisibility(8);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.findViewById(2131366918).setVisibility(0);
  }
  
  public void i(View paramView)
  {
    new axlq().h("video").i("playpage_com_click").b().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ThreadManagerV2.excute(new PlayOperationViewModel.24(this, (axby)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
  }
  
  public void j(View paramView)
  {
    if (this.jdField_a_of_type_Axnd != null) {
      this.jdField_a_of_type_Axnd.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axop
 * JD-Core Version:    0.7.0.1
 */