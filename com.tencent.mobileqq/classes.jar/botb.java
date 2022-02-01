import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@TargetApi(11)
public class botb
  extends botu
  implements View.OnClickListener, borq
{
  public static int a;
  public static final LongSparseArray<bote> a;
  public static final int[] a;
  private LayoutTransition jdField_a_of_type_AndroidAnimationLayoutTransition = new LayoutTransition();
  protected SparseArray<Long> a;
  private View jdField_a_of_type_AndroidViewView;
  protected ViewGroup a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected TextView a;
  protected BubblePopupWindow a;
  private HorizontalAlumbListLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout;
  boolean jdField_a_of_type_Boolean = true;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  public int b;
  private long jdField_b_of_type_Long;
  protected LongSparseArray<ImageView> b;
  protected ViewGroup b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d = true;
  private boolean e;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131365964, 2131365965, 2131365967, 2131365968, 2131365969, 2131365970, 2131365971, 2131365972, 2131365973, 2131365974, 2131365966 };
    jdField_a_of_type_Int = 232575;
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray = new LongSparseArray();
  }
  
  public botb(@NonNull botw parambotw, int paramInt)
  {
    super(parambotw);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray = new LongSparseArray();
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private int a()
  {
    int j = jdField_a_of_type_Int;
    int k = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int;
    int i;
    if (k != 2)
    {
      i = j;
      if (k != 6) {}
    }
    else
    {
      i = j;
      if (bosg.a(this.jdField_b_of_type_Int))
      {
        i = j;
        if (this.jdField_a_of_type_Botw.a()) {
          i = j & 0xFFFFFFF7 & 0xFFFFFFBF & 0xFFFFF7FF;
        }
      }
    }
    return i;
  }
  
  @Nullable
  private String a(bovr parambovr)
  {
    Object localObject1 = null;
    if (parambovr != null)
    {
      localObject1 = parambovr.a();
      parambovr = new StringBuilder();
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        Object localObject3 = (List)((Map.Entry)localObject2).getValue();
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          localObject2 = (String)((Map.Entry)localObject2).getKey();
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            String str = (String)((Iterator)localObject3).next();
            parambovr.append((String)localObject2).append('_').append(str).append(',');
          }
        }
      }
      localObject1 = parambovr.toString();
    }
    return localObject1;
  }
  
  private void a(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131365221: 
    case 2131365222: 
    case 2131365223: 
      do
      {
        long l;
        do
        {
          return;
          l = SystemClock.uptimeMillis();
        } while ((l - this.jdField_c_of_type_Long < 800L) || (this.jdField_a_of_type_Bouo.getActivity().isFinishing()));
        this.jdField_c_of_type_Long = l;
        if (yzz.a().b() == 22)
        {
          LpReportInfo_pf00064.allReport(680, 2, 7);
          LpReportInfo_pf00064.allReport(680, 11, 1);
        }
        this.jdField_a_of_type_Botw.d();
        bnqm.a().c();
        bnqq.a().d();
        bnrh.b("Q.qqstory.record.EditVideoButton", "【Click】+ control_publish");
        k();
        return;
        ykv.b("clk_reshoot", c(), 0, new String[0]);
        if ((this.jdField_a_of_type_Botw instanceof bpik)) {
          ((bpik)this.jdField_a_of_type_Botw).r = true;
        }
        if (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.h()) {
          bdla.b(null, "dc00898", "", "", "0X800A06F", "0X800A06F", 0, 0, "", "", "", "");
        }
        this.jdField_a_of_type_Botw.e();
      } while ((this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int != 2) || (yzz.a().a() != 13) || (this.jdField_a_of_type_Bouo == null) || (this.jdField_a_of_type_Bouo.getActivity() == null));
      ykv.a("video_edit_new", "back_smartalbum", this.jdField_a_of_type_Bouo.getActivity().getIntent(), new String[0]);
      return;
    case 2131379246: 
      book.a(this.jdField_b_of_type_AndroidWidgetImageView, 200L, null);
      this.jdField_a_of_type_Botw.o();
      if ((this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 5) && (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 6)) {
        break;
      }
    }
    for (int i = 1;; i = 0)
    {
      ykv.a("video_edit_aio", "download_clk", 0, i, new String[0]);
      ykv.a("video_edit_new", "clk_download", 0, i, new String[0]);
      return;
      this.jdField_a_of_type_Botw.p();
      return;
    }
  }
  
  private void a(View... paramVarArgs)
  {
    float f1 = FontSettingManager.getFontLevel();
    int j;
    int i;
    if (f1 > 16.0F)
    {
      j = paramVarArgs.length;
      i = 0;
    }
    for (;;)
    {
      View localView;
      if (i < j)
      {
        localView = paramVarArgs[i];
        if ((localView != null) && (localView.getLayoutParams() != null)) {}
      }
      else
      {
        return;
      }
      if ((localView instanceof TextView))
      {
        float f2 = ((TextView)localView).getTextSize();
        float f3 = 16.0F / f1;
        ((TextView)localView).setTextSize(0, f2 * f3);
      }
      i += 1;
    }
  }
  
  private ImageView[] a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    if ((this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 102) || (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 11) || (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 12)) {
      this.jdField_b_of_type_Boolean = true;
    }
    int k = paramInt & a();
    int i = 0;
    int j;
    for (paramInt = 0; i < 18; paramInt = j)
    {
      int m = 1 << i;
      j = paramInt;
      if ((k & m & jdField_a_of_type_Int) == m) {
        j = paramInt + 1;
      }
      i += 1;
    }
    i = jdField_a_of_type_ArrayOfInt.length;
    if (i < paramInt) {
      throw new IllegalArgumentException("too many parts, there is no enough view to show");
    }
    ImageView[] arrayOfImageView = new ImageView[i];
    paramInt = 0;
    Object localObject;
    while (paramInt < i)
    {
      localObject = a(jdField_a_of_type_ArrayOfInt[paramInt]);
      if ((localObject instanceof ImageView))
      {
        arrayOfImageView[paramInt] = ((ImageView)localObject);
        paramInt += 1;
      }
      else
      {
        throw new IllegalArgumentException("can not find ImageView by id : " + jdField_a_of_type_ArrayOfInt[paramInt] + ", view : " + localObject);
      }
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.clear();
    d();
    i = 0;
    for (paramInt = 0;; paramInt = j)
    {
      j = paramInt;
      if (i >= 18) {
        break;
      }
      long l = 1L << i;
      j = paramInt;
      if ((k & l) == l)
      {
        j = paramInt;
        if ((jdField_a_of_type_Int & l) == l)
        {
          localObject = arrayOfImageView[paramInt];
          bote localbote = (bote)jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.get(l);
          if (localbote != null)
          {
            ((ImageView)localObject).setImageResource(localbote.jdField_a_of_type_Int);
            ((ImageView)localObject).setContentDescription(localbote.jdField_a_of_type_JavaLangCharSequence);
            ((ImageView)localObject).setOnClickListener(paramOnClickListener);
            this.jdField_a_of_type_AndroidUtilSparseArray.put(((ImageView)localObject).getId(), Long.valueOf(localbote.jdField_a_of_type_Long));
            this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(localbote.jdField_a_of_type_Long, localObject);
          }
          j = paramInt + 1;
        }
      }
      i += 1;
    }
    while (j < jdField_a_of_type_ArrayOfInt.length)
    {
      arrayOfImageView[j].setOnClickListener(null);
      arrayOfImageView[j].setVisibility(8);
      j += 1;
    }
    return arrayOfImageView;
  }
  
  private void b(int paramInt)
  {
    int i = 3;
    if ((this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
      switch (paramInt)
      {
      default: 
        i = -1;
      }
    }
    for (;;)
    {
      LpReportInfo_pf00064.report(615, i);
      return;
      i = 1;
      continue;
      i = 4;
      continue;
      i = 2;
    }
  }
  
  private void b(View paramView)
  {
    int j = 0;
    TextView localTextView;
    if ((paramView instanceof TextView))
    {
      localTextView = (TextView)paramView;
      if (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() != 102) {
        break label53;
      }
      localTextView.setText(anvx.a(2131703229));
      localTextView.setContentDescription(anvx.a(2131703265));
    }
    label53:
    do
    {
      return;
      if (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 2)
      {
        paramView = anvx.a(2131703406);
        int i = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c();
        if ((i == 122) || (i == 125) || (i == 133) || (EditVideoParams.a(i)) || (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.h())) {
          paramView = a(2131689934);
        }
        i = j;
        if (this.jdField_a_of_type_Bouo.getActivity() != null)
        {
          i = j;
          if (this.jdField_a_of_type_Bouo.getActivity().getIntent() != null)
          {
            i = j;
            if (this.jdField_a_of_type_Bouo.getActivity().getIntent().getBooleanExtra("input_full_screen_mode", false)) {
              i = 1;
            }
          }
        }
        if (i != 0) {
          paramView = a(2131694399);
        }
        localTextView.setText(paramView);
        localTextView.setContentDescription(paramView);
        return;
      }
      if (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 8)
      {
        localTextView.setText(anvx.a(2131703189));
        localTextView.setContentDescription(anvx.a(2131703225));
        return;
      }
      if (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)
      {
        paramView = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_publish_text");
        if (!TextUtils.isEmpty(paramView))
        {
          localTextView.setText(paramView);
          localTextView.setContentDescription(paramView);
          return;
        }
        localTextView.setText(anvx.a(2131703327));
        localTextView.setContentDescription(anvx.a(2131703236));
        return;
      }
    } while ((this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 5) && (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 6));
    localTextView.setText(anvx.a(2131703392));
    localTextView.setContentDescription(anvx.a(2131703407));
    paramView = localTextView.getLayoutParams();
    paramView.width = AIOUtils.dp2px(70.0F, localTextView.getContext().getResources());
    localTextView.setLayoutParams(paramView);
  }
  
  private void c(int paramInt)
  {
    if (yzz.a().b() == 22) {
      LpReportInfo_pf00064.allReport(680, 2, paramInt);
    }
  }
  
  private void d()
  {
    c();
    if ((this.jdField_a_of_type_Botw.a() != null) && ((this.jdField_a_of_type_Botw.a().getActivity() instanceof EditPicActivity))) {
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(32L, new bote(32L, 2130844476, anvx.a(2131703312)));
    }
    int i = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int;
    if ((i == 2) || (i == 6))
    {
      if (this.jdField_a_of_type_Botw.a())
      {
        jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new bote(1024L, 2130844483, anvx.a(2131703401)));
        jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1024L, new bote(1L, 2130844487, anvx.a(2131703342)));
      }
    }
    else
    {
      if ((i != 3) || (yzz.a().b() != 22)) {
        break label436;
      }
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new bote(2L, 2130844485, anvx.a(2131703233)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(2L, new bote(32768L, 2130844475, anvx.a(2131703387)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(8L, new bote(16L, 2130844492, anvx.a(2131703384)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(16L, new bote(8L, 2130844489, anvx.a(2131703203)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(32768L, new bote(1L, 2130844487, anvx.a(2131703216)));
    }
    label436:
    while ((i != 3) || (!this.jdField_a_of_type_Botw.a()))
    {
      return;
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new bote(1024L, 2130844483, anvx.a(2131703244)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(2L, new bote(8L, 2130844489, anvx.a(2131703285)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(8L, new bote(64L, 2130844479, anvx.a(2131703396)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(64L, new bote(1L, 2130844487, anvx.a(2131703223)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1024L, new bote(2L, 2130844485, anvx.a(2131703220)));
      break;
    }
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new bote(1024L, 2130844483, anvx.a(2131703341)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1024L, new bote(1L, 2130844487, anvx.a(2131703279)));
  }
  
  private void i()
  {
    Object localObject = this.jdField_a_of_type_Botw;
    if (botw.a(this.jdField_b_of_type_Int, 512))
    {
      localObject = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = 0;
      }
    }
    if (bosg.a(this.jdField_b_of_type_Int))
    {
      a(this.jdField_b_of_type_AndroidWidgetTextView);
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.dp2px(39.0F, a().getResources());
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, AIOUtils.dp2px(25.0F, a().getResources()), AIOUtils.dp2px(15.0F, a().getResources()));
      int i = 0;
      while (i < this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.size())
      {
        localObject = (ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.valueAt(i);
        if (localObject != null) {
          ((LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams()).setMargins(AIOUtils.dp2px(25.0F, a().getResources()), 0, AIOUtils.dp2px(5.0F, a().getResources()), 0);
        }
        i += 1;
      }
    }
  }
  
  private void k()
  {
    l();
    TransitionCategoryItem localTransitionCategoryItem = bpjt.a().a();
    if (localTransitionCategoryItem != null) {
      ykv.a("video_edit_transition", "pub_effects", boun.a(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_src_from", -1)), 0, new String[] { localTransitionCategoryItem.k, localTransitionCategoryItem.n, localTransitionCategoryItem.l, localTransitionCategoryItem.m });
    }
    if (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 122) {
      AIOLongShotHelper.a("0X8009DEF");
    }
    if (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.h()) {
      bdla.b(null, "dc00898", "", "", "0X800A06E", "0X800A06E", 0, 0, "", "", "", "");
    }
  }
  
  private void l()
  {
    int i = 1;
    try
    {
      localJSONObject = new JSONObject();
      m = this.jdField_a_of_type_Botw.f();
      n = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c();
      if (m == 9) {
        break label612;
      }
      if (m != 2) {
        break label618;
      }
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject;
      int m;
      int n;
      Object localObject1;
      Object localObject3;
      Object localObject4;
      int i1;
      while (QLog.isColorLevel())
      {
        QLog.e("Q.qqstory.record.EditVideoButton", 2, localException, new Object[0]);
        return;
        localObject2 = null;
        continue;
        localObject2 = null;
        continue;
        localObject2 = null;
        continue;
        localObject4 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        continue;
        i = 0;
        localObject2 = null;
        localObject3 = null;
        continue;
        j = 1;
      }
      return;
    }
    localObject1 = a(this.jdField_a_of_type_Botw.jdField_a_of_type_Botf.a().a());
    localObject3 = this.jdField_a_of_type_Botw.jdField_a_of_type_Botf.a().a();
    localObject1 = (String)localObject1 + a((bovr)localObject3);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localJSONObject.put("sticker", localObject1);
    }
    localObject1 = (bmuv)bogd.a(13);
    int j;
    int k;
    if (localObject1 != null)
    {
      if (((bmuv)localObject1).a() == 4) {
        i = 2;
      }
      for (;;)
      {
        localObject3 = ((bmuv)localObject1).b();
        localObject4 = ((bmuv)localObject1).a();
        if (j == 0) {
          break;
        }
        localObject3 = localObject3[1];
        localObject1 = localObject4[1];
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localJSONObject.put("effect", localObject3);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localJSONObject.put("filter", localObject1);
        }
        localObject1 = (boje)bogd.a(8);
        if ((localObject1 == null) || (((boje)localObject1).b() == null)) {
          break label580;
        }
        localObject1 = String.valueOf(((boje)localObject1).b().mItemId);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localJSONObject.put("music", localObject1);
        }
        if (j != 0)
        {
          localObject1 = (bpqs)bogd.a(3);
          if (localObject1 == null) {
            break label574;
          }
          localObject1 = ((bpqs)localObject1).a();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localJSONObject.put("face", localObject1);
          }
        }
        localObject1 = this.jdField_a_of_type_Botw.jdField_a_of_type_Botf.a().a().a();
        if (localObject1 == null) {
          break label568;
        }
        localObject1 = String.valueOf(((DynamicTextItem)localObject1).c());
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localJSONObject.put("text", localObject1);
        }
        ykv.a("video_edit_new", "send_clk", c(), 0, new String[] { ykv.b(m), localJSONObject.toString(), String.valueOf(i), String.valueOf(n) });
        return;
        if (((bmuv)localObject1).a() != 8) {
          i = 0;
        }
      }
      i1 = localObject3.length;
      k = 0;
      localObject1 = null;
    }
    for (;;)
    {
      String str;
      if (k < i1)
      {
        str = localObject3[k];
        if (str != null) {
          localObject1 = str + ",";
        }
      }
      else
      {
        i1 = localObject4.length;
        k = 0;
        localObject3 = null;
        while (k < i1)
        {
          str = localObject4[k];
          if (str != null) {
            localObject3 = str + ",";
          }
          k += 1;
        }
        label568:
        Object localObject2;
        label574:
        label580:
        label612:
        label618:
        j = 0;
        break;
      }
      k += 1;
    }
  }
  
  private void n()
  {
    QzoneModuleManager.getInstance().downloadModule("cyber_clink_version_2.jar", new botd(this));
  }
  
  public View a()
  {
    if (this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray != null) {
      return (View)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(16L);
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131365222));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131365223));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131365221));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = a(2131365975);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    b(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364153));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = a(this.jdField_b_of_type_Int, this);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364160));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364155));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout = ((HorizontalAlumbListLayout)a(2131371889));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131379246));
    if ((this.jdField_b_of_type_Int & 0x200) != 0)
    {
      if ((this.jdField_a_of_type_Botw instanceof bpik)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847894);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131379228));
      if ((this.jdField_b_of_type_Int & 0x10000) == 0) {
        break label598;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if ((QzoneModuleManager.getInstance().isModuleDownloaded("cyber_clink_version_2.jar")) && (!QzoneModuleManager.getInstance().checkIfNeedUpdate("cyber_clink_version_2.jar"))) {
        break label587;
      }
      n();
      label297:
      if (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 102) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      i();
      a(new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView });
      a(this.jdField_a_of_type_ArrayOfAndroidWidgetImageView);
      this.jdField_a_of_type_AndroidAnimationLayoutTransition.setAnimator(3, ObjectAnimator.ofFloat(null, "alpha", new float[] { 1.0F, 0.0F }));
      this.jdField_a_of_type_AndroidAnimationLayoutTransition.setDuration(3, 500L);
      this.jdField_a_of_type_AndroidAnimationLayoutTransition.setAnimator(2, ObjectAnimator.ofFloat(null, "alpha", new float[] { 0.0F, 1.0F }));
      this.jdField_a_of_type_AndroidAnimationLayoutTransition.setDuration(2, 500L);
      int i = this.jdField_a_of_type_Bouo.getActivity().getIntent().getIntExtra("pic_entrance_type", -1);
      if ((!this.jdField_a_of_type_Botw.a()) || (i == 1) || (i == 2) || (i == 3) || (i == 11) || (i == 13)) {
        break label610;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131703409));
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anvx.a(2131703276));
    }
    for (;;)
    {
      a(borq.class, this);
      this.jdField_a_of_type_Boolean = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).getBoolean("showFlashPic", true);
      Bundle localBundle = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle;
      if (localBundle != null) {
        this.e = localBundle.getBoolean("key_enable_edit_title_bar", false);
      }
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label587:
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      break label297;
      label598:
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label297;
      label610:
      if (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131703227));
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anvx.a(2131703250));
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131703359));
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anvx.a(2131703303));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
    }
    switch (paramInt2)
    {
    case 12: 
    case 18: 
    case 19: 
    case 20: 
    default: 
    case 0: 
    case 11: 
    case 15: 
    case 16: 
      do
      {
        return;
        a(null);
        this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundColor(this.jdField_c_of_type_Int);
        if (paramInt1 == 6) {
          a(true, true, false);
        }
        for (;;)
        {
          if (this.d)
          {
            this.jdField_a_of_type_Botw.a(Message.obtain(null, 12, 3, (int)this.jdField_a_of_type_Long));
            this.d = false;
          }
          if ((!this.e) || (!this.jdField_a_of_type_Botw.a())) {
            break;
          }
          if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          if ((this.jdField_b_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0) || ((this.jdField_b_of_type_Int & 0x200) == 0)) {
            break;
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
          if (paramInt1 == 11) {
            a(true, true, false);
          } else {
            a(true, false);
          }
        }
        a(false, true, false);
        ykw.b("0X80080E5", ykw.jdField_a_of_type_Int);
        return;
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        return;
      } while (paramInt1 != 15);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
    case 9: 
      a(null);
      a(true, false);
      return;
    case 4: 
      a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(1024L));
      this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundColor(a().getColor(2131165373));
      if (paramInt1 == 5) {
        if ((paramObject != null) && ((paramObject instanceof Boolean))) {
          a(true, true, ((Boolean)paramObject).booleanValue());
        }
      }
      while (((this.jdField_b_of_type_Int & 0x4000) != 0) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null))
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setVisibility(8);
        return;
        a(true, true);
        continue;
        a(true, false);
      }
    case 2: 
      if ((paramInt1 != paramInt2) && (this.jdField_b_of_type_Boolean)) {
        a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(1L));
      }
      int j = -1;
      int i = j;
      if (paramObject != null)
      {
        i = j;
        if ((paramObject instanceof Integer)) {
          i = ((Integer)paramObject).intValue();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.record.EditVideoButton", 2, "editVideoStateChanged text old:" + paramInt1 + " new:" + paramInt2 + " softInputMode:" + i);
      }
      if (i == 0) {
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      for (;;)
      {
        b(false, false, true);
        if ((!this.e) || (!this.jdField_a_of_type_Botw.a())) {
          break;
        }
        if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        }
        if ((this.jdField_b_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0)) {
          break;
        }
        a(4);
        return;
        a(true, false);
      }
    case 3: 
      a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(8L));
      b(false, false, true);
      return;
    case 5: 
      if ((paramObject != null) && ((paramObject instanceof Boolean)))
      {
        a(false, ((Boolean)paramObject).booleanValue());
        return;
      }
      a(false, true);
      return;
    case 6: 
      a(false, true);
      return;
    case 8: 
      a(false, false);
      return;
    case 7: 
      a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(4L));
      a(false, false);
      return;
    case 1: 
      a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(2L));
      b(false, false, true);
      return;
    case 13: 
      a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(64L));
      b(false, false, true);
      return;
    case 14: 
      a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(32L));
      b(false, false, true);
      return;
    case 17: 
      a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(16L));
      b(false, false, true);
      return;
    case 10: 
      a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(2048L));
      return;
    }
    a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(131072L));
    b(false, false, true);
  }
  
  public void a(int paramInt, @NonNull bpel parambpel)
  {
    super.a(paramInt, parambpel);
  }
  
  protected void a(@Nullable ImageView paramImageView)
  {
    int i = 0;
    while (i < this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.size())
    {
      ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.valueAt(i);
      if (localImageView != null)
      {
        localImageView.getDrawable().clearColorFilter();
        localImageView.clearColorFilter();
      }
      i += 1;
    }
    if (paramImageView != null) {
      paramImageView.setColorFilter(a().getColor(2131166307), PorterDuff.Mode.SRC_IN);
    }
  }
  
  public void a(TextView paramTextView)
  {
    paramTextView.setTextColor(a().getColor(2131167059));
    paramTextView.setTextSize(0, a().getDimension(2131296737));
    paramTextView.setBackgroundResource(2130839347);
    paramTextView.setMinimumHeight(a().getDimensionPixelSize(2131296736));
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 1;
    int j = 0;
    if (paramBoolean) {}
    for (;;)
    {
      ykq.d("Q.qqstory.record.EditVideoButton", "setEnableButtonEnable: %d", new Object[] { Integer.valueOf(i) });
      this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
      i = j;
      while (i < this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.size())
      {
        long l = this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.keyAt(i);
        ((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(l)).setEnabled(paramBoolean);
        i += 1;
      }
      i = 0;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = 8;
    if (paramBoolean2)
    {
      this.jdField_a_of_type_Long = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.jdField_a_of_type_Long += 500L;
      }
      if (paramBoolean1) {
        bovj.a(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
      }
      for (;;)
      {
        this.jdField_a_of_type_Botw.a(Message.obtain(null, 11, Long.valueOf(this.jdField_a_of_type_Long)));
        if (!paramBoolean1) {
          break;
        }
        i = 0;
        while (i < this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.size())
        {
          ((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.valueAt(i)).setVisibility(0);
          i += 1;
        }
        bovj.a(this.jdField_a_of_type_AndroidViewViewGroup);
      }
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramBoolean1) {}
    for (int i = 0;; i = 8)
    {
      ((ViewGroup)localObject).setVisibility(i);
      this.jdField_a_of_type_Long = 0L;
      break;
    }
    if (((this.jdField_b_of_type_Int & 0x4000) != 0) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null))
    {
      localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout;
      i = j;
      if (paramBoolean1) {
        i = 0;
      }
      ((HorizontalAlumbListLayout)localObject).setVisibility(i);
    }
    if (paramBoolean1)
    {
      if (this.jdField_c_of_type_AndroidViewViewGroup.getVisibility() != 0) {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() != 0) {
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      }
    }
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(paramMessage.arg1);
      if (localImageView != null)
      {
        ykq.b("Q.qqstory.record.EditVideoButton", "perform button click %s", localImageView);
        localImageView.performClick();
      }
      else
      {
        ykq.d("Q.qqstory.record.EditVideoButton", "can not find view performing click by enable mask %d", new Object[] { Integer.valueOf(paramMessage.arg1) });
      }
    }
  }
  
  public void aI_()
  {
    super.aI_();
    if ((this.jdField_a_of_type_Botw.jdField_a_of_type_Int == 0) && (!this.jdField_c_of_type_Boolean))
    {
      if (((this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) || ((this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)))
      {
        int i = AIOUtils.dp2px(-48.0F, a());
        ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_c_of_type_AndroidViewViewGroup, "translationY", new float[] { i, 0.0F });
        localObjectAnimator1.setDuration(800L);
        i = AIOUtils.dp2px(a().getDimension(2131298074), a());
        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewViewGroup, "translationY", new float[] { i, 0.0F });
        localObjectAnimator2.setDuration(800L);
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
        localAnimatorSet.start();
      }
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public void b()
  {
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(16L);
    if (localImageView != null) {
      localImageView.setImageResource(2130844491);
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = 0;
    if (paramBoolean2)
    {
      this.jdField_a_of_type_Long = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.jdField_a_of_type_Long += 500L;
      }
      if (paramBoolean1) {
        bovj.a(this.jdField_b_of_type_AndroidViewViewGroup, paramBoolean3);
      }
      for (;;)
      {
        this.jdField_a_of_type_Botw.a(Message.obtain(null, 11, Long.valueOf(this.jdField_a_of_type_Long)));
        if (!paramBoolean1) {
          break;
        }
        i = 0;
        while (i < this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.size())
        {
          ((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.valueAt(i)).setVisibility(0);
          i += 1;
        }
        bovj.a(this.jdField_b_of_type_AndroidViewViewGroup);
      }
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setAnimation(null);
    Object localObject = this.jdField_b_of_type_AndroidViewViewGroup;
    if (paramBoolean1) {}
    for (int i = 0;; i = 8)
    {
      ((ViewGroup)localObject).setVisibility(i);
      this.jdField_a_of_type_Long = 0L;
      break;
    }
    if (((this.jdField_b_of_type_Int & 0x4000) != 0) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null))
    {
      localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout;
      if (!paramBoolean1) {
        break label204;
      }
    }
    label204:
    for (i = j;; i = 8)
    {
      ((HorizontalAlumbListLayout)localObject).setVisibility(i);
      return;
    }
  }
  
  public void c()
  {
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(2L, new bote(2L, 2130844485, anvx.a(2131703314)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1024L, new bote(1024L, 2130844483, anvx.a(2131703264)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new bote(1L, 2130844487, anvx.a(2131703353)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(8L, new bote(8L, 2130844489, anvx.a(2131703315)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(4L, new bote(4L, 2130844477, anvx.a(2131703358)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(64L, new bote(64L, 2130844479, anvx.a(2131703348)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(32L, new bote(32L, 2130844476, anvx.a(2131703397)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(16L, new bote(16L, 2130844492, anvx.a(2131703403)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(2048L, new bote(2048L, 2130844486, "跳转到P图"));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(32768L, new bote(32768L, 2130844475, anvx.a(2131703268)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(131072L, new bote(131072L, 2130844484, BaseApplicationImpl.getContext().getString(2131691817)));
  }
  
  public boolean l_()
  {
    return System.currentTimeMillis() < this.jdField_a_of_type_Long;
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    int k;
    if (Math.abs(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long) > 500L)
    {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      k = paramView.getId();
      if (this.jdField_a_of_type_Long <= System.currentTimeMillis()) {
        break label94;
      }
      ykq.d("Q.qqstory.record.EditVideoButton", "animation is playing, please wait, animation end time: %d, now: %d.", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(System.currentTimeMillis()) });
    }
    label94:
    Object localObject;
    int i;
    label106:
    long l;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ykq.d("Q.qqstory.record.EditVideoButton", "you click button too fast, ignore it !");
      continue;
      localObject = jdField_a_of_type_ArrayOfInt;
      int m = localObject.length;
      i = 0;
      if (i >= m) {
        break label1280;
      }
      if (localObject[i] != k) {
        break label1273;
      }
      l = ((Long)this.jdField_a_of_type_AndroidUtilSparseArray.get(k)).longValue();
      ykq.d("Q.qqstory.record.EditVideoButton", "onClick : mask=%d, view=%s", new Object[] { Long.valueOf(l), paramView });
      i = this.jdField_a_of_type_Botw.a(Message.obtain(null, 1, new Object[] { Long.valueOf(l), paramView }));
      if (i <= 0) {
        break;
      }
      ykq.c("Q.qqstory.record.EditVideoButton", "%d parts intercept the click event : " + i);
    }
    this.jdField_a_of_type_Botw.y();
    this.jdField_a_of_type_Botw.q();
    switch ((int)(0xFFFFFFFF & l))
    {
    default: 
      label344:
      i = -1;
    }
    label1280:
    label1288:
    for (;;)
    {
      label346:
      localObject = null;
      if (i != -1) {
        localObject = new botc(this, i);
      }
      if ((jdField_a_of_type_Int & l) != l) {
        break;
      }
      book.a(paramView, 200L, (View.OnClickListener)localObject);
      break;
      if (this.jdField_a_of_type_Botw.a(21))
      {
        this.jdField_a_of_type_Botw.a(0);
        i = -1;
      }
      else
      {
        i = 21;
        continue;
        if (this.jdField_a_of_type_Botw.a(1)) {
          this.jdField_a_of_type_Botw.a(0);
        }
        for (i = -1;; i = 1)
        {
          c(1);
          ykv.b("clk_music", c(), 0, new String[0]);
          break;
        }
        if (this.jdField_a_of_type_Botw.a(4)) {
          this.jdField_a_of_type_Botw.a(0);
        }
        for (i = -1;; i = 4)
        {
          ykw.b("0X80075C4", ykw.jdField_a_of_type_Int);
          ykv.b("clk_graffiti", c(), 0, new String[0]);
          b(1024);
          if (!this.jdField_a_of_type_Botw.a()) {
            break label1288;
          }
          bcwl.a("0X800B3C5", this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c());
          break;
        }
        if (this.jdField_a_of_type_Botw.a(2)) {
          this.jdField_a_of_type_Botw.a(0);
        }
        for (;;)
        {
          ykw.b("0X80075C6", ykw.jdField_a_of_type_Int);
          ykv.b("clk_text", c(), 0, new String[0]);
          b(1);
          c(9);
          if (!this.jdField_a_of_type_Botw.a()) {
            break;
          }
          bcwl.a("0X800B3C9", this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c());
          i = -1;
          break label346;
          this.jdField_a_of_type_Botw.t();
        }
        if (this.jdField_a_of_type_Botw.a(3)) {
          this.jdField_a_of_type_Botw.a(0);
        }
        for (i = -1;; i = 3)
        {
          ykw.b("0X80075C7", ykw.jdField_a_of_type_Int);
          b(8);
          ykv.a("video_edit_new", "clk_sticker", c(), 0, new String[0]);
          c(12);
          break;
        }
        this.jdField_a_of_type_Botw.r();
        ykw.b("0X80075C5", ykw.jdField_a_of_type_Int);
        b(4);
        ykv.a("video_edit_new", "clk_cut", c(), 0, new String[0]);
        bcwl.a("0X800B3C7", this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c());
        i = -1;
        continue;
        if (this.jdField_a_of_type_Botw.a(13))
        {
          this.jdField_a_of_type_Botw.a(0);
          label799:
          i = c();
          if (!this.jdField_a_of_type_Botw.a()) {
            break label874;
          }
        }
        label874:
        for (localObject = "1";; localObject = "2")
        {
          ykv.a("video_edit_new", "clk_filter", i, 0, new String[] { "", localObject, "", "" });
          i = -1;
          break;
          this.jdField_a_of_type_Botw.a(13);
          break label799;
        }
        if (this.jdField_a_of_type_Botw.a(14)) {
          this.jdField_a_of_type_Botw.a(0);
        }
        for (i = -1;; i = 14)
        {
          ykv.b("clk_effect", c(), 0, new String[0]);
          c(10);
          break;
        }
        localObject = (bosy)a(bosy.class);
        if (localObject == null) {
          break label344;
        }
        if (((bosy)localObject).a() == 0)
        {
          if (this.jdField_a_of_type_Botw.a(17)) {
            this.jdField_a_of_type_Botw.a(0);
          }
          for (i = -1;; i = 17)
          {
            ykv.a("video_edit_transition", "clk_transition", boun.a(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_src_from", -1)), 0, new String[0]);
            c(11);
            break;
          }
        }
        ((bosy)localObject).b();
        ykv.a("video_edit_transition", "exp_toastFail", boun.a(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_src_from", -1)), 0, new String[0]);
        break;
        if (this.jdField_a_of_type_Botw.jdField_a_of_type_Int == 10)
        {
          this.jdField_a_of_type_Botw.a(0);
          label1090:
          i = j;
          if (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 2)
          {
            i = j;
            if (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 5) {
              if (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 6) {
                break label1186;
              }
            }
          }
        }
        label1186:
        for (i = j;; i = 0)
        {
          ykv.a("video_edit_aio", "ttpt_clk", 0, i, new String[0]);
          ykv.a("video_edit_new", "clk_pitu", 0, i, new String[0]);
          i = -1;
          break;
          this.jdField_a_of_type_Botw.a(10);
          break label1090;
        }
        if (yzz.a().b() == 22) {
          LpReportInfo_pf00064.allReport(680, 2, 2);
        }
        localObject = new ArrayList(yzz.a().a());
        QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
        Bundle localBundle = new Bundle();
        localBundle.putParcelableArrayList("qzone_slide_show_matters", (ArrayList)localObject);
        QZoneHelper.forwardToQzDynamicEditVideoActivity(this.jdField_a_of_type_Bouo.getActivity(), localUserInfo, localBundle, 666);
        i = -1;
        continue;
        label1273:
        i += 1;
        break label106;
        a(paramView);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     botb
 * JD-Core Version:    0.7.0.1
 */