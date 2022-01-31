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
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.XEditTextEx;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditGifImage;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@TargetApi(11)
public class bmla
  extends bmnh
  implements View.OnClickListener, bmio
{
  public static int a;
  public static long a;
  public static final LongSparseArray<bmlj> a;
  public static final int[] a;
  private LayoutTransition jdField_a_of_type_AndroidAnimationLayoutTransition = new LayoutTransition();
  protected SparseArray<Long> a;
  private View jdField_a_of_type_AndroidViewView;
  protected ViewGroup a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  protected TextView a;
  protected BubblePopupWindow a;
  private HorizontalAlumbListLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout;
  public HashSet<Integer> a;
  boolean jdField_a_of_type_Boolean = true;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  private int jdField_b_of_type_Int;
  public long b;
  protected LongSparseArray<ImageView> b;
  private View jdField_b_of_type_AndroidViewView;
  protected ViewGroup b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  protected ViewGroup c;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean = false;
  private View jdField_d_of_type_AndroidViewView;
  protected ViewGroup d;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  public boolean d;
  private long jdField_e_of_type_Long;
  private View jdField_e_of_type_AndroidViewView;
  protected ViewGroup e;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private View jdField_f_of_type_AndroidViewView;
  protected ViewGroup f;
  private boolean jdField_f_of_type_Boolean;
  private ViewGroup jdField_g_of_type_AndroidViewViewGroup;
  private boolean jdField_g_of_type_Boolean;
  private ViewGroup jdField_h_of_type_AndroidViewViewGroup;
  private boolean jdField_h_of_type_Boolean = true;
  private ViewGroup jdField_i_of_type_AndroidViewViewGroup;
  private boolean jdField_i_of_type_Boolean;
  private ViewGroup j;
  private boolean k;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131365556, 2131365557, 2131365561, 2131365562, 2131365563, 2131365564, 2131365565, 2131365566, 2131365567, 2131365568, 2131365558, 2131365559, 2131365560 };
    jdField_a_of_type_Long = 2750423236735L;
    jdField_a_of_type_Int = 268435456;
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray = new LongSparseArray();
  }
  
  public bmla(@NonNull bmnj parambmnj, long paramLong)
  {
    super(parambmnj);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray = new LongSparseArray();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_Long = paramLong;
  }
  
  @Nullable
  private String a(bmqg parambmqg)
  {
    Object localObject1 = null;
    if (parambmqg != null)
    {
      localObject1 = parambmqg.a();
      parambmqg = new StringBuilder();
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
            parambmqg.append((String)localObject2).append('_').append(str).append(',');
          }
        }
      }
      localObject1 = parambmqg.toString();
    }
    return localObject1;
  }
  
  private void a(View paramView)
  {
    int m = paramView.getId();
    switch (m)
    {
    case 2131365569: 
    default: 
    case 2131364830: 
    case 2131364831: 
    case 2131364832: 
      do
      {
        long l;
        do
        {
          return;
          l = SystemClock.uptimeMillis();
        } while ((l - this.jdField_e_of_type_Long < 800L) || (this.jdField_a_of_type_Bmor.getActivity().isFinishing()));
        this.jdField_e_of_type_Long = l;
        paramView = (bmiv)a(bmiv.class);
        if ((paramView != null) && (!paramView.b()))
        {
          this.jdField_a_of_type_Bmnj.s();
          return;
        }
        if (xna.a().b() == 22)
        {
          LpReportInfo_pf00064.allReport(680, 2, 7);
          LpReportInfo_pf00064.allReport(680, 11, 1);
        }
        q();
        this.jdField_a_of_type_Bmnj.d();
        bliu.a().c();
        bliy.a().d();
        bljn.b("Q.qqstory.record.EditVideoButton", "【Click】+ control_publish");
        n();
        return;
        q();
        wxj.b("clk_reshoot", c(), 0, new String[0]);
        if ((this.jdField_a_of_type_Bmnj instanceof bnfs)) {
          ((bnfs)this.jdField_a_of_type_Bmnj).s = true;
        }
        if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.j()) {
          azqs.b(null, "dc00898", "", "", "0X800A06F", "0X800A06F", 0, 0, "", "", "", "");
        }
        this.jdField_a_of_type_Bmnj.e();
        if ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int == 5) && (uul.a != null)) {
          wxj.a("video_edit_text", "clk_goback", uul.a.jdField_a_of_type_Int, 0, new String[0]);
        }
      } while ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int != 2) || (xna.a().a() != 13) || (this.jdField_a_of_type_Bmor == null) || (this.jdField_a_of_type_Bmor.getActivity() == null));
      wxj.a("video_edit_new", "back_smartalbum", this.jdField_a_of_type_Bmor.getActivity().getIntent(), new String[0]);
      return;
    case 2131364810: 
      r();
      q();
      return;
    case 2131371712: 
      this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(12));
      bmar.a(paramView, 200L, new bmld(this));
      wxj.b("clk_control", c(), 0, new String[0]);
      return;
    case 2131362594: 
      p();
      return;
    case 2131378170: 
      bmar.a(this.jdField_c_of_type_AndroidWidgetImageView, 200L, null);
      this.jdField_a_of_type_Bmnj.q();
      if ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 5) && (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 6)) {
        break;
      }
    }
    for (m = 1;; m = 0)
    {
      wxj.a("video_edit_aio", "download_clk", 0, m, new String[0]);
      wxj.a("video_edit_new", "clk_download", 0, m, new String[0]);
      return;
      this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(10));
      bmar.a(paramView, 200L, new bmle(this));
      return;
      this.jdField_a_of_type_Bmnj.r();
      return;
      this.jdField_a_of_type_Bmnj.a(34);
      return;
      paramView = new bmyu(a(), this.jdField_a_of_type_Bmnj);
      paramView.setOnShowListener(new bmlf(this));
      paramView.setOnDismissListener(new bmlg(this, paramView));
      paramView.a();
      if (m == 2131365839)
      {
        paramView.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), false);
        return;
      }
      paramView.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), true);
      return;
    }
  }
  
  private void a(View... paramVarArgs)
  {
    float f1 = alsf.a();
    int n;
    int m;
    if (f1 > 16.0F)
    {
      n = paramVarArgs.length;
      m = 0;
    }
    for (;;)
    {
      View localView;
      if (m < n)
      {
        localView = paramVarArgs[m];
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
      m += 1;
    }
  }
  
  private ImageView[] a(long paramLong, @NonNull ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    if ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 102) || (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 11) || (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 12)) {
      this.jdField_c_of_type_Boolean = true;
    }
    int i2 = jdField_a_of_type_ArrayOfInt.length;
    paramLong = (jdField_a_of_type_Long | jdField_a_of_type_Int) & 0x723182FF & paramLong;
    int n = 0;
    int m = 0;
    long l;
    while (m < 41)
    {
      l = 1L << m;
      i1 = n;
      if ((paramLong & l & jdField_a_of_type_Long) == l) {
        i1 = n + 1;
      }
      m += 1;
      n = i1;
    }
    wxe.a("Q.qqstory.record.EditVideoButton", "initEditButtons, needFirstStepButtonCount = %d", Integer.valueOf(n));
    if (i2 < n) {
      throw new IllegalArgumentException("too many parts, there is no enough view to show");
    }
    ImageView[] arrayOfImageView = new ImageView[i2];
    m = 0;
    while (m < i2)
    {
      paramViewGroup = a(jdField_a_of_type_ArrayOfInt[m]);
      if ((paramViewGroup instanceof ImageView))
      {
        arrayOfImageView[m] = ((ImageView)paramViewGroup);
        m += 1;
      }
      else
      {
        throw new IllegalArgumentException("can not find ImageView by id : " + jdField_a_of_type_ArrayOfInt[m] + ", view : " + paramViewGroup);
      }
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    j();
    n = 0;
    m = 11;
    i2 = 0;
    int i1 = n;
    if (i2 < 41)
    {
      l = 1L << i2;
      i1 = m;
      int i3 = n;
      label334:
      bmlj localbmlj;
      if ((paramLong & l) == l)
      {
        if ((jdField_a_of_type_Long & l) != l) {
          break label461;
        }
        paramViewGroup = arrayOfImageView[n];
        n += 1;
        localbmlj = (bmlj)jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.get(l);
        if (localbmlj == null) {
          break label556;
        }
      }
      for (;;)
      {
        try
        {
          paramViewGroup.setImageDrawable(new BitmapDrawable(BitmapFactory.decodeResource(a(), localbmlj.jdField_a_of_type_Int)));
          if (l == 33554432L) {
            this.jdField_f_of_type_AndroidViewView = paramViewGroup;
          }
          paramViewGroup.setContentDescription(localbmlj.jdField_a_of_type_JavaLangCharSequence);
          paramViewGroup.setOnClickListener(paramOnClickListener);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(paramViewGroup.getId(), Long.valueOf(localbmlj.jdField_a_of_type_Long));
          this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(localbmlj.jdField_a_of_type_Long, paramViewGroup);
          i3 = n;
          i1 = m;
          i2 += 1;
          m = i1;
          n = i3;
          break;
          label461:
          if (((jdField_a_of_type_Int & l) == l) && (m < jdField_a_of_type_ArrayOfInt.length))
          {
            paramViewGroup = jdField_a_of_type_ArrayOfInt;
            i1 = m + 1;
            paramViewGroup = (ImageView)a(paramViewGroup[m]);
            m = i1;
            break label334;
          }
          wxe.e("Q.qqstory.record.EditVideoButton", "initEditButtons second step buttons not enough");
          i1 = m;
          i3 = n;
          continue;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          wxe.e("Q.qqstory.record.EditVideoButton", "decodeResource OutOfMemoryError : %s", new Object[] { localbmlj.jdField_a_of_type_JavaLangCharSequence });
          continue;
        }
        label556:
        wxe.e("Q.qqstory.record.EditVideoButton", "EntryButtonInfo info is null ?!");
        i1 = m;
        i3 = n;
      }
    }
    for (;;)
    {
      n = m;
      if (i1 >= 11) {
        break;
      }
      arrayOfImageView[i1].setOnClickListener(null);
      arrayOfImageView[i1].setVisibility(8);
      i1 += 1;
    }
    while (n < jdField_a_of_type_ArrayOfInt.length)
    {
      arrayOfImageView[n].setOnClickListener(null);
      arrayOfImageView[n].setVisibility(8);
      n += 1;
    }
    return arrayOfImageView;
  }
  
  private void b(View paramView)
  {
    TextView localTextView;
    int m;
    int n;
    if ((paramView instanceof TextView))
    {
      localTextView = (TextView)paramView;
      m = this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a();
      n = this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c();
      if (m != 101) {
        break label64;
      }
      localTextView.setText(alud.a(2131704270));
      localTextView.setContentDescription(alud.a(2131704287));
    }
    label64:
    do
    {
      return;
      if (m == 102)
      {
        localTextView.setText(alud.a(2131704139));
        localTextView.setContentDescription(alud.a(2131704175));
        return;
      }
      if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 2)
      {
        paramView = alud.a(2131704320);
        m = this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c();
        if ((m == 122) || (m == 125) || (m == 133) || (EditVideoParams.a(m)) || (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.j())) {
          paramView = a(2131689991);
        }
        localTextView.setText(paramView);
        localTextView.setContentDescription(paramView);
        return;
      }
      if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 8)
      {
        localTextView.setText(alud.a(2131704099));
        localTextView.setContentDescription(alud.a(2131704135));
        return;
      }
      if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1)
      {
        paramView = alud.a(2131704167);
        if (n == 20) {
          paramView = alud.a(2131704244);
        }
        localTextView.setText(paramView);
        localTextView.setContentDescription(paramView);
        return;
      }
      if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)
      {
        paramView = this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_publish_text");
        if (!TextUtils.isEmpty(paramView))
        {
          localTextView.setText(paramView);
          localTextView.setContentDescription(paramView);
          return;
        }
        localTextView.setText(alud.a(2131704240));
        localTextView.setContentDescription(alud.a(2131704146));
        return;
      }
      if ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 6))
      {
        localTextView.setText(alud.a(2131704306));
        localTextView.setContentDescription(alud.a(2131704321));
        paramView = localTextView.getLayoutParams();
        paramView.width = aepi.a(70.0F, localTextView.getContext().getResources());
        localTextView.setLayoutParams(paramView);
        return;
      }
    } while (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 7);
    localTextView.setText(alud.a(2131689628));
    localTextView.setContentDescription(alud.a(2131689628));
  }
  
  private void c(int paramInt)
  {
    int n = 3;
    boolean bool;
    int m;
    if ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3))
    {
      bool = this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e();
      if (!bool) {
        break label105;
      }
      m = 628;
      switch (paramInt)
      {
      default: 
        paramInt = -1;
      }
    }
    for (;;)
    {
      if (!bool) {
        break label156;
      }
      LpReportInfo_pf00064.allReport(m, paramInt);
      return;
      label105:
      m = 615;
      break;
      paramInt = n;
      if (!bool)
      {
        paramInt = 1;
        continue;
        paramInt = n;
        if (bool)
        {
          paramInt = 2;
          continue;
          if (bool) {}
          paramInt = 4;
          continue;
          if (bool) {}
          paramInt = 4;
        }
      }
    }
    label156:
    LpReportInfo_pf00064.report(m, paramInt);
  }
  
  private void d(int paramInt)
  {
    if (xna.a().b() == 22) {
      LpReportInfo_pf00064.allReport(680, 2, paramInt);
    }
  }
  
  private void j()
  {
    y_();
    if ((this.jdField_a_of_type_Bmnj.a() != null) && ((this.jdField_a_of_type_Bmnj.a().getActivity() instanceof EditPicActivity))) {
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(32L, new bmlj(32L, 2130844127, alud.a(2131704225)));
    }
    int m = this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int;
    if ((m == 2) || (m == 6))
    {
      if (this.jdField_a_of_type_Bmnj.a())
      {
        jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new bmlj(536870912L, 2130844135, alud.a(2131704315)));
        jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(536870912L, new bmlj(1L, 2130844139, alud.a(2131704255)));
      }
    }
    else
    {
      if ((m != 3) || (xna.a().b() != 22)) {
        break label436;
      }
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new bmlj(2L, 2130844137, alud.a(2131704143)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(2L, new bmlj(549755813888L, 2130844126, alud.a(2131704301)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(8L, new bmlj(16L, 2130844144, alud.a(2131704298)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(16L, new bmlj(8L, 2130844141, alud.a(2131704113)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(549755813888L, new bmlj(1L, 2130844139, alud.a(2131704126)));
    }
    label436:
    while ((m != 3) || (!this.jdField_a_of_type_Bmnj.a()))
    {
      return;
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new bmlj(536870912L, 2130844135, alud.a(2131704154)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(2L, new bmlj(8L, 2130844141, alud.a(2131704196)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(8L, new bmlj(64L, 2130844130, alud.a(2131704310)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(64L, new bmlj(1L, 2130844139, alud.a(2131704133)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(536870912L, new bmlj(2L, 2130844137, alud.a(2131704130)));
      break;
    }
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new bmlj(536870912L, 2130844135, alud.a(2131704254)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(536870912L, new bmlj(1L, 2130844139, alud.a(2131704190)));
  }
  
  private void k()
  {
    Object localObject = this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle;
    RelativeLayout.LayoutParams localLayoutParams;
    if ((localObject != null) && (((Bundle)localObject).getInt("video_redbag_get", 0) == LocalMediaInfo.REDBAG_TYPE_GET) && (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_g_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(a()).inflate(2131561561, null));
      localObject = (RelativeLayout)a(2131363822);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        break label154;
      }
      if (!this.jdField_a_of_type_Bmnj.jdField_e_of_type_Boolean) {
        break label144;
      }
      localLayoutParams.bottomMargin = this.jdField_a_of_type_Bmnj.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
      localLayoutParams.addRule(12, -1);
    }
    for (;;)
    {
      ((RelativeLayout)localObject).addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
      wxe.d("Q.qqstory.record.EditVideoButton", "VideoRedbag, editVideoButton show redbag tips");
      return;
      label144:
      localLayoutParams.addRule(12, -1);
      continue;
      label154:
      localLayoutParams.addRule(2, 2131363824);
    }
  }
  
  private void l()
  {
    if ((this.jdField_b_of_type_Long & 0x20000) != 0L) {}
    label153:
    for (;;)
    {
      return;
      Object localObject = null;
      if ((this.jdField_b_of_type_Long & 0x4000000) != 0L) {
        localObject = a(2131362113);
      }
      for (;;)
      {
        if (localObject == null) {
          break label153;
        }
        localObject = ((View)localObject).getLayoutParams();
        if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
          break;
        }
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = 0;
        return;
        if ((this.jdField_b_of_type_Long & 0x0) != 0L) {
          localObject = a(2131379593);
        } else if ((this.jdField_b_of_type_Long & 0x0) != 0L) {
          localObject = a(2131363591);
        } else if ((this.jdField_b_of_type_Long & 0x2000) != 0L) {
          localObject = this.jdField_c_of_type_AndroidWidgetImageView;
        } else if ((this.jdField_b_of_type_Long & 0x4000) != 0L) {
          localObject = a(2131378175);
        }
      }
    }
  }
  
  private void n()
  {
    o();
    Object localObject = bnhb.a().a();
    if (localObject != null) {
      wxj.a("video_edit_transition", "pub_effects", bmoq.a(this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_src_from", -1)), 0, new String[] { ((TransitionCategoryItem)localObject).k, ((TransitionCategoryItem)localObject).n, ((TransitionCategoryItem)localObject).l, ((TransitionCategoryItem)localObject).m });
    }
    if ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int == 5) && (uul.a != null)) {
      wxj.a("video_edit_text", "clk_pub", uul.a.jdField_a_of_type_Int, 0, new String[] { uul.a.jdField_a_of_type_JavaLangString, uul.a.b, uul.a.c });
    }
    if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("is_video_forward", false)) {
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length() <= 0) {
        break label393;
      }
    }
    label393:
    for (localObject = "1";; localObject = "0")
    {
      wxj.a("video_edit", "pub_transmit", 0, 0, new String[] { "1", localObject });
      if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
        wxj.b("time_edit", 1, (int)(System.currentTimeMillis() - this.jdField_a_of_type_Bmnj.d()), new String[] { wxj.b(this.jdField_a_of_type_Bmnj.g()), "0", "", "" });
      }
      if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
        wxj.b("clk_function", 1, 0, new String[] { ShortVideoUtils.a(this.jdField_a_of_type_JavaUtilHashSet), "", "", "" });
      }
      if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 122) {
        AIOLongShotHelper.a("0X8009DEF");
      }
      if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.j()) {
        azqs.b(null, "dc00898", "", "", "0X800A06E", "0X800A06E", 0, 0, "", "", "", "");
      }
      return;
    }
  }
  
  private void o()
  {
    int n;
    try
    {
      localJSONObject = new JSONObject();
      i2 = this.jdField_a_of_type_Bmnj.g();
      i3 = this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c();
      if (i2 == 9) {
        break label606;
      }
      if (i2 != 2) {
        break label612;
      }
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject;
      int i2;
      int i3;
      Object localObject1;
      Object localObject3;
      int m;
      String[] arrayOfString;
      Object localObject4;
      int i4;
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
        localObject4 = null;
        localObject3 = null;
        continue;
        m = 0;
        continue;
        n = 1;
      }
      return;
    }
    localObject1 = a(this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmlp.a().a());
    localObject3 = this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmlp.a().a();
    localObject1 = (String)localObject1 + a((bmqg)localObject3);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localJSONObject.put("sticker", localObject1);
    }
    localObject1 = (bknb)blqr.a(13);
    if (((bknb)localObject1).a() == 4) {
      m = 2;
    }
    int i1;
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject3 = ((bknb)localObject1).b();
        arrayOfString = ((bknb)localObject1).a();
        if (n != 0)
        {
          localObject3 = localObject3[1];
          localObject4 = arrayOfString[1];
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            localJSONObject.put("effect", localObject3);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            localJSONObject.put("filter", localObject4);
          }
          localObject1 = (blua)blqr.a(8);
          if ((localObject1 == null) || (((blua)localObject1).b() == null)) {
            break label586;
          }
          localObject1 = String.valueOf(((blua)localObject1).b().mItemId);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localJSONObject.put("music", localObject1);
          }
          if (n != 0)
          {
            localObject1 = (bnpl)blqr.a(3);
            if (localObject1 == null) {
              break label580;
            }
            localObject1 = ((bnpl)localObject1).a();
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              localJSONObject.put("face", localObject1);
            }
          }
          localObject1 = this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmlp.a().a().a();
          if (localObject1 != null)
          {
            localObject1 = String.valueOf(((DynamicTextItem)localObject1).c());
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              localJSONObject.put("text", localObject1);
            }
            wxj.a("video_edit_new", "send_clk", c(), 0, new String[] { wxj.b(i2), localJSONObject.toString(), String.valueOf(m), String.valueOf(i3) });
            return;
            if (((bknb)localObject1).a() != 8) {
              break label601;
            }
            m = 1;
          }
        }
        else
        {
          i4 = localObject3.length;
          i1 = 0;
          localObject1 = null;
        }
      }
    }
    for (;;)
    {
      if (i1 < i4)
      {
        localObject4 = localObject3[i1];
        if (localObject4 != null) {
          localObject1 = (String)localObject4 + ",";
        }
      }
      else
      {
        i4 = arrayOfString.length;
        i1 = 0;
        String str = null;
        for (;;)
        {
          localObject3 = localObject1;
          localObject4 = str;
          if (i1 >= i4) {
            break;
          }
          localObject3 = arrayOfString[i1];
          if (localObject3 != null) {
            str = (String)localObject3 + ",";
          }
          i1 += 1;
        }
        Object localObject2;
        label580:
        label586:
        label601:
        label606:
        label612:
        n = 0;
        break;
      }
      i1 += 1;
    }
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e()) || (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.f()))
    {
      if (!this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.jdField_d_of_type_Boolean) {
        break label79;
      }
      a(true, false);
      this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.a.removeMessages(994);
      this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.a.sendEmptyMessage(995);
    }
    label79:
    do
    {
      return;
      this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.a.sendEmptyMessageDelayed(994, 0L);
    } while (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.jdField_b_of_type_Boolean);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText("0%");
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847655);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373323);
      if (localView != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(localView);
      }
    }
    if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmmv != null) {
      this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmmv.d();
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_Bmnj.B();
    this.jdField_a_of_type_Bmnj.h();
    this.jdField_a_of_type_Bmnj.a(0);
    this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_c_of_type_AndroidViewViewGroup.setAlpha(0.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new blzp(this.jdField_d_of_type_AndroidViewViewGroup, "translationY", 0.0F, xsm.a(a(), 160.0F), 300L, 0L));
    localArrayList.add(new blzp(this.jdField_d_of_type_AndroidViewViewGroup, "alpha", 1.0F, 0.0F, 300L, 0L));
    localArrayList.add(new blzp(this.jdField_c_of_type_AndroidViewViewGroup, "translationY", a().getDimension(2131297923), 0.0F, 300L, 300L));
    localArrayList.add(new blzp(this.jdField_c_of_type_AndroidViewViewGroup, "alpha", 0.0F, 1.0F, 300L, 300L));
    localArrayList.add(new blzp(this.jdField_a_of_type_AndroidWidgetTextView, "translationY", -1.0F * a().getDimension(2131297924), 0.0F, 300L, 300L));
    localArrayList.add(new blzp(this.jdField_a_of_type_AndroidWidgetTextView, "alpha", 0.0F, 1.0F, 300L, 300L));
    localArrayList.add(new blzp(this.jdField_f_of_type_AndroidViewViewGroup, "translationY", 0.0F, -1.0F * a().getDimension(2131297924), 300L, 0L));
    localArrayList.add(new blzp(this.jdField_f_of_type_AndroidViewViewGroup, "alpha", 1.0F, 0.0F, 300L, 0L));
    localArrayList.add(new blzp(this.jdField_e_of_type_AndroidViewViewGroup, "translationY", 0.0F, -1.0F * a().getDimension(2131297924), 300L, 0L));
    localArrayList.add(new blzp(this.jdField_e_of_type_AndroidViewViewGroup, "alpha", 1.0F, 0.0F, 300L, 0L));
    blzm.a(localArrayList, new bmlh(this));
    this.jdField_d_of_type_Long = (System.currentTimeMillis() + 600L);
    this.jdField_a_of_type_Bmnj.a(Message.obtain(null, 11, Long.valueOf(this.jdField_d_of_type_Long)));
    this.jdField_a_of_type_Bmnj.a(Message.obtain(null, 12, 1, (int)this.jdField_d_of_type_Long));
  }
  
  private void s()
  {
    QzoneModuleManager.getInstance().downloadModule("cyber_clink_version_2.jar", new bmli(this));
  }
  
  public View a()
  {
    if (this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray != null) {
      return (View)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(16L);
    }
    return null;
  }
  
  public View a(long paramLong)
  {
    if (this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray != null) {
      return (View)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(paramLong);
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131364831));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131364832));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131364830));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = a(2131365569);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    b(this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131363822));
    this.jdField_h_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131365803));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = a(this.jdField_b_of_type_Long, this.jdField_h_of_type_AndroidViewViewGroup, this);
    this.jdField_g_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131363830));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131363824));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout = ((HorizontalAlumbListLayout)a(2131371064));
    if (bmnj.a(this.jdField_b_of_type_Long, 17179869184L))
    {
      this.jdField_b_of_type_Int = a().getColor(2131166408);
      this.jdField_a_of_type_AndroidWidgetEditText = ((XEditTextEx)a(2131365839));
      this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(TroopBarPublishUtils.a);
      aahb.a(a(), this.jdField_a_of_type_AndroidWidgetEditText);
      a(2131365839).setOnClickListener(this);
      a(2131365679).setOnClickListener(this);
      this.j = ((ViewGroup)a(2131369660));
      this.j.setVisibility(0);
    }
    Object localObject;
    if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      localObject = (ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.getParent();
      ((ViewGroup)localObject).removeView(this.jdField_c_of_type_AndroidViewViewGroup);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewViewGroup.getLayoutParams();
      localLayoutParams.topMargin = bdoo.a(14.0F);
      localLayoutParams.addRule(10, -1);
      localLayoutParams.addRule(12, 0);
      this.jdField_a_of_type_Bmnj.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewViewGroup, localLayoutParams);
      if (bmnj.a(this.jdField_b_of_type_Long, 17179869184L))
      {
        ((ViewGroup)localObject).removeView(this.j);
        localLayoutParams = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
        localLayoutParams.bottomMargin = this.jdField_a_of_type_Bmnj.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height;
        ((ViewGroup)localObject).addView(this.j, localLayoutParams);
      }
    }
    this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131363826));
    this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131377440));
    this.jdField_b_of_type_AndroidViewViewGroup = this.jdField_c_of_type_AndroidViewViewGroup;
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)a(2131365804));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getViewTreeObserver().addOnScrollChangedListener(new bmlb(this));
    this.jdField_i_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131372460));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131372456));
    this.jdField_f_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364810));
    this.jdField_f_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = a(2131371712);
    this.jdField_c_of_type_AndroidViewView = ((PressDarkImageButton)a(2131377340));
    if ((this.jdField_b_of_type_Long & 0x20000) != 0L)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    }
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131378170));
    if ((this.jdField_b_of_type_Long & 0x2000) != 0L)
    {
      if ((this.jdField_a_of_type_Bmnj instanceof bnfs)) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130847415);
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)a(2131378175));
      if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmim == null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)a(2131378154));
      if ((this.jdField_b_of_type_Long & 0x0) == 0L) {
        break label1286;
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if ((QzoneModuleManager.getInstance().isModuleDownloaded("cyber_clink_version_2.jar")) && (!QzoneModuleManager.getInstance().checkIfNeedUpdate("cyber_clink_version_2.jar"))) {
        break label1275;
      }
      s();
      label783:
      l();
      if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 102) {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131362594));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131362598));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131362595));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131362596));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131362597));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      a(new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_c_of_type_AndroidWidgetTextView });
      a(this.jdField_a_of_type_ArrayOfAndroidWidgetImageView);
      this.jdField_a_of_type_AndroidAnimationLayoutTransition.setAnimator(3, ObjectAnimator.ofFloat(null, "alpha", new float[] { 1.0F, 0.0F }));
      this.jdField_a_of_type_AndroidAnimationLayoutTransition.setDuration(3, 500L);
      this.jdField_a_of_type_AndroidAnimationLayoutTransition.setAnimator(2, ObjectAnimator.ofFloat(null, "alpha", new float[] { 0.0F, 1.0F }));
      this.jdField_a_of_type_AndroidAnimationLayoutTransition.setDuration(2, 500L);
      this.jdField_d_of_type_AndroidViewView = a(2131377448);
      this.jdField_e_of_type_AndroidViewView = a(2131362113);
      if ((this.jdField_b_of_type_Long & 0x4000000) == 0L) {
        break label1298;
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      label1088:
      int m = this.jdField_a_of_type_Bmor.getActivity().getIntent().getIntExtra("pic_entrance_type", -1);
      if ((!this.jdField_a_of_type_Bmnj.a()) || (m == 1) || (m == 2) || (m == 3) || (m == 11) || (m == 13)) {
        break label1319;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131704323));
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alud.a(2131704187));
    }
    for (;;)
    {
      a(bmio.class, this);
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).getBoolean("showFlashPic", true);
      if (this.jdField_a_of_type_Bmnj.a()) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131704236));
      }
      localObject = this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle;
      if (localObject != null) {
        this.k = ((Bundle)localObject).getBoolean("key_enable_edit_title_bar", false);
      }
      return;
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label1275:
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      break label783;
      label1286:
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      break label783;
      label1298:
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      break label1088;
      label1319:
      if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131704137));
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alud.a(2131704160));
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131704272));
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alud.a(2131704216));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  public void a(int paramInt)
  {
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(1048576L);
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
    }
    switch (paramInt2)
    {
    case 20: 
    case 22: 
    case 25: 
    case 33: 
    case 35: 
    case 38: 
    case 39: 
    case 41: 
    default: 
    case 0: 
    case 27: 
    case 31: 
    case 32: 
    case 10: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 19: 
    case 24: 
    case 7: 
    case 5: 
    case 6: 
    case 18: 
    case 8: 
    case 9: 
    case 23: 
    case 1: 
    case 3: 
    case 4: 
    case 12: 
    case 34: 
    case 37: 
    case 42: 
    case 11: 
    case 21: 
    case 28: 
    case 2: 
    case 29: 
    case 30: 
    case 36: 
    case 40: 
      label237:
      label246:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    a(null);
                    this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundColor(this.jdField_b_of_type_Int);
                    if (paramInt1 == 9)
                    {
                      paramInt2 = 1;
                      if (paramInt1 != 23) {
                        break label403;
                      }
                      m = 1;
                      if ((m | paramInt2) == 0) {
                        break label409;
                      }
                      a(true, true, false);
                    }
                    for (;;)
                    {
                      if ((this.j != null) && (this.j.getVisibility() != 0)) {
                        this.j.setVisibility(0);
                      }
                      if (this.jdField_h_of_type_Boolean)
                      {
                        this.jdField_a_of_type_Bmnj.a(Message.obtain(null, 12, 3, (int)this.jdField_d_of_type_Long));
                        this.jdField_h_of_type_Boolean = false;
                      }
                      if ((!this.k) || (!this.jdField_a_of_type_Bmnj.a())) {
                        break;
                      }
                      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
                        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
                      }
                      if ((this.jdField_c_of_type_AndroidWidgetImageView == null) || (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0) || ((this.jdField_b_of_type_Long & 0x2000) == 0L)) {
                        break;
                      }
                      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
                      return;
                      paramInt2 = 0;
                      break label237;
                      m = 0;
                      break label246;
                      if (paramInt1 == 27) {
                        a(true, true, false);
                      } else {
                        b(true, false);
                      }
                    }
                    a(false, true, false);
                    wxk.b("0X80080E5", wxk.jdField_a_of_type_Int);
                    return;
                    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
                    return;
                  } while (paramInt1 != 31);
                  this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
                  return;
                  a(null);
                  b(true, false);
                  return;
                  a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(536870912L));
                  this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundColor(a().getColor(2131165323));
                  if (paramInt1 == 8) {
                    if ((paramObject != null) && ((paramObject instanceof Boolean))) {
                      a(true, true, ((Boolean)paramObject).booleanValue());
                    }
                  }
                  for (;;)
                  {
                    if ((this.j != null) && (this.j.getVisibility() == 0)) {
                      this.j.setVisibility(8);
                    }
                    if (((this.jdField_b_of_type_Long & 0x0) == 0L) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout == null)) {
                      break;
                    }
                    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setVisibility(8);
                    return;
                    b(true, true);
                    continue;
                    b(true, false);
                  }
                  if ((paramInt1 != paramInt2) && (this.jdField_c_of_type_Boolean)) {
                    a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(1L));
                  }
                  int n = -1;
                  int m = n;
                  if (paramObject != null)
                  {
                    m = n;
                    if ((paramObject instanceof Integer)) {
                      m = ((Integer)paramObject).intValue();
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i("Q.qqstory.record.EditVideoButton", 2, "editVideoStateChanged text old:" + paramInt1 + " new:" + paramInt2 + " softInputMode:" + m);
                  }
                  if (m == 0) {
                    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
                  }
                  for (;;)
                  {
                    b(false, false, true);
                    if (this.j != null) {
                      this.j.setVisibility(8);
                    }
                    if ((!this.k) || (!this.jdField_a_of_type_Bmnj.a())) {
                      break;
                    }
                    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
                      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
                    }
                    if ((this.jdField_c_of_type_AndroidWidgetImageView == null) || (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 0)) {
                      break;
                    }
                    b(4);
                    return;
                    b(true, false);
                  }
                  a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(8L));
                  b(false, false, true);
                } while (this.j == null);
                this.j.setVisibility(8);
                return;
                a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(1024L));
                return;
                if ((paramObject != null) && ((paramObject instanceof Boolean)))
                {
                  b(false, ((Boolean)paramObject).booleanValue());
                  return;
                }
                b(false, true);
                return;
                b(false, true);
                return;
                b(false, false);
                return;
                a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(4L));
                b(false, false);
                return;
                a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(32768L));
                b(false, false);
                return;
                a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(2097152L));
                return;
                a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(2L));
                b(false, false, true);
              } while (this.j == null);
              this.j.setVisibility(8);
              return;
              a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(64L));
              b(false, false, true);
            } while (this.j == null);
            this.j.setVisibility(8);
            return;
            a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(32L));
            b(false, false, true);
          } while (this.j == null);
          this.j.setVisibility(8);
          return;
          b(false, false, true);
        } while (this.j == null);
        this.j.setVisibility(8);
        return;
        a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(16L));
        b(false, false, true);
      } while (this.j == null);
      label403:
      label409:
      this.j.setVisibility(8);
      return;
    }
    a((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(1073741824L));
  }
  
  public void a(int paramInt, @NonNull bnaz parambnaz)
  {
    super.a(paramInt, parambnaz);
    parambnaz.jdField_e_of_type_Boolean = this.jdField_d_of_type_Boolean;
    if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("is_video_forward", false))
    {
      Object localObject2 = this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams;
      Object localObject1 = ((EditVideoParams)localObject2).a("vip_forward_uid");
      String str1 = ((EditVideoParams)localObject2).a("vip_forward_vid");
      String str2 = ((EditVideoParams)localObject2).a("vip_forward_feedid");
      String str3 = ((EditVideoParams)localObject2).a("vip_forward_name");
      String str4 = ((EditVideoParams)localObject2).a("vip_forward_avatrname");
      localObject2 = new uxp();
      ((uxp)localObject2).jdField_a_of_type_Int = 5;
      ((uxp)localObject2).jdField_a_of_type_Uxq = new uxq();
      ((uxp)localObject2).jdField_a_of_type_Uxq.jdField_a_of_type_JavaLangString = ((String)localObject1);
      ((uxp)localObject2).jdField_a_of_type_Uxq.c = str1;
      ((uxp)localObject2).jdField_a_of_type_Uxq.b = str2;
      ((uxp)localObject2).jdField_a_of_type_Uxq.f = str3;
      ((uxp)localObject2).jdField_a_of_type_Uxq.g = str4;
      ((uxp)localObject2).jdField_a_of_type_Uxq.e = "1";
      str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (str1.length() > 0)
      {
        localObject1 = str1;
        if (banh.a(str1)) {
          localObject1 = azah.a(str1);
        }
        ((uxp)localObject2).jdField_a_of_type_Uxq.d = ((String)localObject1);
      }
      parambnaz.a.setLinkInfo((uxp)localObject2);
    }
  }
  
  protected void a(@Nullable ImageView paramImageView)
  {
    int m = 0;
    while (m < this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.size())
    {
      ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.valueAt(m);
      if (localImageView != null) {
        localImageView.clearColorFilter();
      }
      m += 1;
    }
    if (paramImageView != null) {
      paramImageView.setColorFilter(a().getColor(2131166204), PorterDuff.Mode.SRC_IN);
    }
    if (this.jdField_e_of_type_Boolean)
    {
      paramImageView = (ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(2L);
      if (paramImageView != null) {
        paramImageView.setColorFilter(a().getColor(2131166204), PorterDuff.Mode.SRC_IN);
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    if (!paramBoolean2)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847223);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847224);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean2)
    {
      this.jdField_d_of_type_Long = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.jdField_d_of_type_Long += 500L;
      }
      if (paramBoolean1) {
        bmpt.b(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bmnj.a(Message.obtain(null, 11, Long.valueOf(this.jdField_d_of_type_Long)));
        if (!paramBoolean1) {
          break;
        }
        m = 0;
        while (m < this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.size())
        {
          ((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.valueAt(m)).setVisibility(0);
          m += 1;
        }
        bmpt.a(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
      }
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramBoolean1) {}
    for (int m = 0;; m = 8)
    {
      ((ViewGroup)localObject).setVisibility(m);
      this.jdField_d_of_type_Long = 0L;
      break;
    }
    if ((this.jdField_b_of_type_Long & 0x20000) != 0L)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    if (((this.jdField_b_of_type_Long & 0x0) != 0L) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null))
    {
      localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout;
      if (!paramBoolean1) {
        break label335;
      }
    }
    label335:
    for (m = 0;; m = 8)
    {
      ((HorizontalAlumbListLayout)localObject).setVisibility(m);
      if (paramBoolean1)
      {
        if (this.jdField_g_of_type_AndroidViewViewGroup.getVisibility() != 0) {
          this.jdField_g_of_type_AndroidViewViewGroup.setVisibility(0);
        }
        if (this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() != 0) {
          this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        }
      }
      if ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidViewViewGroup == this.jdField_c_of_type_AndroidViewViewGroup) && (!paramBoolean1) && (this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 0)) {
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      }
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (!paramBoolean1)) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      return;
    }
  }
  
  public boolean a()
  {
    if (System.currentTimeMillis() < this.jdField_d_of_type_Long) {
      return true;
    }
    if (this.jdField_b_of_type_AndroidViewViewGroup == this.jdField_d_of_type_AndroidViewViewGroup)
    {
      r();
      q();
      return true;
    }
    return false;
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
        wxe.b("Q.qqstory.record.EditVideoButton", "perform button click %s", localImageView);
        localImageView.performClick();
      }
      else
      {
        wxe.d("Q.qqstory.record.EditVideoButton", "can not find view performing click by enable mask %d", new Object[] { Integer.valueOf(paramMessage.arg1) });
        continue;
        if (this.jdField_f_of_type_AndroidViewView != null) {
          if (paramMessage.arg1 == 1)
          {
            this.jdField_f_of_type_AndroidViewView.setAlpha(0.5F);
            this.jdField_i_of_type_Boolean = true;
          }
          else
          {
            this.jdField_f_of_type_AndroidViewView.setAlpha(1.0F);
            this.jdField_i_of_type_Boolean = false;
            continue;
            q();
          }
        }
      }
    }
  }
  
  public void b()
  {
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(16L);
    if (localImageView != null) {
      localImageView.setImageResource(2130844143);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    int m = 1;
    int n = 0;
    if (paramBoolean) {}
    for (;;)
    {
      wxe.d("Q.qqstory.record.EditVideoButton", "setEnableButtonEnable: %d", new Object[] { Integer.valueOf(m) });
      this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
      m = n;
      while (m < this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.size())
      {
        long l = this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.keyAt(m);
        ((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(l)).setEnabled(paramBoolean);
        m += 1;
      }
      m = 0;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, true);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int n = 0;
    if (paramBoolean2)
    {
      this.jdField_d_of_type_Long = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.jdField_d_of_type_Long += 500L;
      }
      if (paramBoolean1) {
        bmpt.b(this.jdField_b_of_type_AndroidViewViewGroup, paramBoolean3);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bmnj.a(Message.obtain(null, 11, Long.valueOf(this.jdField_d_of_type_Long)));
        if (!paramBoolean1) {
          break;
        }
        m = 0;
        while (m < this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.size())
        {
          ((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.valueAt(m)).setVisibility(0);
          m += 1;
        }
        bmpt.a(this.jdField_b_of_type_AndroidViewViewGroup, paramBoolean3);
      }
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setAnimation(null);
    Object localObject = this.jdField_b_of_type_AndroidViewViewGroup;
    if (paramBoolean1) {}
    for (int m = 0;; m = 8)
    {
      ((ViewGroup)localObject).setVisibility(m);
      this.jdField_d_of_type_Long = 0L;
      break;
    }
    if ((this.jdField_b_of_type_Long & 0x20000) != 0L)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    if (((this.jdField_b_of_type_Long & 0x0) != 0L) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null))
    {
      localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout;
      if (!paramBoolean1) {
        break label236;
      }
    }
    label236:
    for (m = n;; m = 8)
    {
      ((HorizontalAlumbListLayout)localObject).setVisibility(m);
      return;
    }
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Bmnj.a(33))
    {
      this.jdField_a_of_type_Bmnj.a(0);
      return;
    }
    this.jdField_a_of_type_Bmnj.a(33, Integer.valueOf(1001));
  }
  
  public void f()
  {
    super.f();
    if ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_Int == 0) && (!this.jdField_f_of_type_Boolean))
    {
      if (((this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) || ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)))
      {
        int m = aepi.a(-48.0F, a());
        ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_g_of_type_AndroidViewViewGroup, "translationY", new float[] { m, 0.0F });
        localObjectAnimator1.setDuration(800L);
        m = aepi.a(a().getDimension(2131297923), a());
        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewViewGroup, "translationY", new float[] { m, 0.0F });
        localObjectAnimator2.setDuration(800L);
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
        localAnimatorSet.start();
      }
      this.jdField_f_of_type_Boolean = true;
    }
  }
  
  public void i_(boolean paramBoolean)
  {
    super.i_(paramBoolean);
    k();
  }
  
  public void onClick(View paramView)
  {
    int n;
    if (Math.abs(SystemClock.uptimeMillis() - this.jdField_c_of_type_Long) > 500L)
    {
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      n = paramView.getId();
      if (this.jdField_d_of_type_Long > System.currentTimeMillis()) {
        wxe.d("Q.qqstory.record.EditVideoButton", "animation is playing, please wait, animation end time: %d, now: %d.", new Object[] { Long.valueOf(this.jdField_d_of_type_Long), Long.valueOf(System.currentTimeMillis()) });
      }
    }
    else
    {
      wxe.d("Q.qqstory.record.EditVideoButton", "you click button too fast, ignore it !");
      return;
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    Object localObject1 = jdField_a_of_type_ArrayOfInt;
    int i1 = localObject1.length;
    int m = 0;
    for (;;)
    {
      if (m >= i1) {
        break label2248;
      }
      if (localObject1[m] == n)
      {
        long l = ((Long)this.jdField_a_of_type_AndroidUtilSparseArray.get(n)).longValue();
        wxe.d("Q.qqstory.record.EditVideoButton", "onClick : mask=%d, view=%s", new Object[] { Long.valueOf(l), paramView });
        wxk.a(this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007822");
        q();
        m = this.jdField_a_of_type_Bmnj.a(Message.obtain(null, 1, new Object[] { Long.valueOf(l), paramView }));
        if (m > 0)
        {
          wxe.c("Q.qqstory.record.EditVideoButton", "%d parts intercept the click event : " + m);
          return;
        }
        this.jdField_a_of_type_Bmnj.B();
        this.jdField_a_of_type_Bmnj.s();
        n = -1;
        switch ((int)(l >> 31))
        {
        default: 
          label284:
          switch ((int)(0xFFFFFFFF & l))
          {
          default: 
            m = n;
          }
          break;
        }
        for (;;)
        {
          localObject1 = null;
          if (m != -1) {
            localObject1 = new bmlc(this, m);
          }
          if ((jdField_a_of_type_Long & l) != l) {
            break;
          }
          bmar.a(paramView, 200L, (View.OnClickListener)localObject1);
          return;
          if (xna.a().b() == 22) {
            LpReportInfo_pf00064.allReport(680, 2, 2);
          }
          localObject1 = new ArrayList(xna.a().a());
          Object localObject2 = bjea.a();
          Object localObject3 = new Bundle();
          ((Bundle)localObject3).putParcelableArrayList("qzone_slide_show_matters", (ArrayList)localObject1);
          bjdt.f(this.jdField_a_of_type_Bmor.getActivity(), (bjea)localObject2, (Bundle)localObject3, 666);
          break label284;
          this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(2));
          if (this.jdField_a_of_type_Bmnj.a(2))
          {
            this.jdField_a_of_type_Bmnj.a(0);
            m = -1;
            d(1);
            wxj.b("clk_music", c(), 0, new String[0]);
          }
          else
          {
            boolean bool = this.jdField_a_of_type_Bmnj.b(4);
            localObject1 = (uus)((uvb)uwa.a(20)).a(1);
            if (((uus)localObject1).a((uuv)((uus)localObject1).a()))
            {
              localObject1 = "2";
              label663:
              if (!this.jdField_a_of_type_Bmnj.a()) {
                break label737;
              }
              localObject2 = "2";
              label678:
              if (!bool) {
                break label745;
              }
            }
            label737:
            label745:
            for (localObject3 = "1";; localObject3 = "0")
            {
              wxj.a("video_edit", "clk_music", 0, 0, new String[] { localObject2, localObject1, localObject3, "" });
              m = 2;
              break;
              localObject1 = "1";
              break label663;
              localObject2 = "1";
              break label678;
            }
            this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(6));
            bool = this.jdField_a_of_type_Bmnj.b(5);
            if (this.jdField_a_of_type_Bmnj.a())
            {
              localObject1 = "2";
              label791:
              if (!bool) {
                break label951;
              }
            }
            label951:
            for (localObject2 = "1";; localObject2 = "0")
            {
              wxj.a("video_edit", "clk_graffiti", 0, 0, new String[] { localObject1, "", localObject2, "" });
              wxj.b("clk_graffiti", c(), 0, new String[0]);
              wxk.a(this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007821");
              this.jdField_a_of_type_Bmnj.a("608", "10", "0", true);
              wxk.b("0X80075C4", wxk.jdField_a_of_type_Int);
              wxk.a(this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X800781E");
              c(536870912);
              if (!this.jdField_a_of_type_Bmnj.a(7)) {
                break label959;
              }
              this.jdField_a_of_type_Bmnj.a(0);
              m = n;
              break;
              localObject1 = "1";
              break label791;
            }
            label959:
            m = 7;
            continue;
            this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(1));
            wxk.b("0X80075C6", wxk.jdField_a_of_type_Int);
            wxk.a(this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007820");
            wxj.b("clk_text", c(), 0, new String[0]);
            c(1);
            if (this.jdField_a_of_type_Bmnj.a(5)) {
              this.jdField_a_of_type_Bmnj.a(0);
            }
            for (;;)
            {
              d(9);
              m = n;
              break;
              this.jdField_a_of_type_Bmnj.w();
            }
            this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(3));
            this.jdField_a_of_type_Bmnj.b(3);
            wxj.a("video_edit_new", "clk_sticker", c(), 0, new String[0]);
            d(12);
            wxk.b("0X80075C7", wxk.jdField_a_of_type_Int);
            c(8);
            this.jdField_a_of_type_Bmnj.a("608", "11", "0", true);
            wxk.a(this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X800781D");
            if (this.jdField_a_of_type_Bmnj.a(6))
            {
              this.jdField_a_of_type_Bmnj.a(0);
              m = n;
            }
            else
            {
              m = 6;
              continue;
              localObject2 = this.jdField_a_of_type_Bmnj;
              if (this.jdField_a_of_type_Bmnj.a()) {}
              for (localObject1 = "2";; localObject1 = "1")
              {
                ((bmnj)localObject2).a("add_tag", 0, 0, new String[] { localObject1 });
                this.jdField_a_of_type_Bmnj.a(1);
                m = n;
                break;
              }
              wxk.b("0X80075C8", wxk.jdField_a_of_type_Int);
              if ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
                LpReportInfo_pf00064.report(615, 5);
              }
              this.jdField_a_of_type_Bmnj.v();
              m = n;
              continue;
              this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(7));
              wxk.b("0X80075C5", wxk.jdField_a_of_type_Int);
              if ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
                LpReportInfo_pf00064.report(615, 2);
              }
              this.jdField_a_of_type_Bmnj.t();
              wxj.a("video_edit_new", "clk_cut", c(), 0, new String[0]);
              m = n;
              continue;
              wxj.a("video_edit", "edit_alt", 0, 0, new String[0]);
              this.jdField_a_of_type_Bmnj.a(18);
              m = n;
              continue;
              wxj.a("video_edit", "share_to_group", 0, 0, new String[0]);
              wxj.a("story_grp", "clk_share_grp", 0, 0, new String[] { "", "", "", "" });
              this.jdField_a_of_type_Bmnj.a(25);
              m = n;
              continue;
              this.jdField_a_of_type_Bmnj.a(21);
              m = n;
              if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
              {
                m = n;
                if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3) {
                  if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e())
                  {
                    LpReportInfo_pf00064.allReport(628, 5, 1);
                    m = n;
                  }
                  else
                  {
                    LpReportInfo_pf00064.report(615, 5);
                    m = n;
                    continue;
                    if (!this.jdField_e_of_type_Boolean) {}
                    for (bool = true;; bool = false)
                    {
                      this.jdField_e_of_type_Boolean = bool;
                      this.jdField_a_of_type_Bmnj.d(this.jdField_e_of_type_Boolean);
                      localObject1 = (ImageView)paramView;
                      localObject2 = (ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(2L);
                      if (!this.jdField_e_of_type_Boolean) {
                        break label1653;
                      }
                      ((ImageView)localObject1).setImageResource(2130846084);
                      m = n;
                      if (localObject2 == null) {
                        break;
                      }
                      ((ImageView)localObject2).setColorFilter(a().getColor(2131166204), PorterDuff.Mode.SRC_IN);
                      m = n;
                      break;
                    }
                    label1653:
                    ((ImageView)localObject1).setImageResource(2130846083);
                    m = n;
                    if (localObject2 != null)
                    {
                      ((ImageView)localObject2).clearColorFilter();
                      m = n;
                      continue;
                      if (this.jdField_a_of_type_Bmnj.a(28))
                      {
                        this.jdField_a_of_type_Bmnj.a(0);
                        m = n;
                      }
                      else
                      {
                        this.jdField_a_of_type_Bmnj.a(28);
                        m = n;
                        continue;
                        m = c();
                        if (this.jdField_a_of_type_Bmnj.a()) {}
                        for (localObject1 = "1";; localObject1 = "2")
                        {
                          wxj.a("video_edit_new", "clk_filter", m, 0, new String[] { "", localObject1, "", "" });
                          if (!this.jdField_a_of_type_Bmnj.a(29)) {
                            break label1808;
                          }
                          this.jdField_a_of_type_Bmnj.a(0);
                          m = n;
                          break;
                        }
                        label1808:
                        this.jdField_a_of_type_Bmnj.a(29);
                        m = n;
                        continue;
                        this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(4));
                        if (this.jdField_a_of_type_Bmnj.a(30)) {
                          this.jdField_a_of_type_Bmnj.a(0);
                        }
                        for (m = n;; m = 30)
                        {
                          wxj.b("clk_effect", c(), 0, new String[0]);
                          d(10);
                          break;
                        }
                        localObject1 = (bmkn)a(bmkn.class);
                        m = n;
                        if (localObject1 != null)
                        {
                          if (((bmkn)localObject1).a() == 0)
                          {
                            if (this.jdField_a_of_type_Bmnj.a(40)) {
                              this.jdField_a_of_type_Bmnj.a(0);
                            }
                            for (m = n;; m = 40)
                            {
                              wxj.a("video_edit_transition", "clk_transition", bmoq.a(this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_src_from", -1)), 0, new String[0]);
                              d(11);
                              break;
                            }
                          }
                          ((bmkn)localObject1).b();
                          wxj.a("video_edit_transition", "exp_toastFail", bmoq.a(this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_src_from", -1)), 0, new String[0]);
                          return;
                          this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(5));
                          if (this.jdField_i_of_type_Boolean)
                          {
                            QQToast.a(a(), alud.a(2131704201), 0).a();
                            return;
                          }
                          if (!this.jdField_a_of_type_Bmnj.a(0)) {
                            this.jdField_a_of_type_Bmnj.a(0);
                          }
                          this.jdField_a_of_type_Bmnj.C();
                          azqs.b(null, "dc00899", "grp_story", "", "video_edit", "edit_linkbar", 0, 0, "2", "0", "", "");
                          m = n;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_Int == 26)
        {
          this.jdField_a_of_type_Bmnj.a(0);
          label2144:
          if ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 5) && (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 6)) {
            break label2236;
          }
        }
        label2236:
        for (m = 1;; m = 0)
        {
          wxj.a("video_edit_aio", "ttpt_clk", 0, m, new String[0]);
          wxj.a("video_edit_new", "clk_pitu", 0, m, new String[0]);
          m = n;
          break;
          this.jdField_a_of_type_Bmnj.a(26);
          break label2144;
        }
      }
      m += 1;
    }
    label2248:
    a(paramView);
  }
  
  public void y_()
  {
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(2L, new bmlj(2L, 2130844137, alud.a(2131704227)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(536870912L, new bmlj(536870912L, 2130844135, alud.a(2131704174)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new bmlj(1L, 2130844139, alud.a(2131704266)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(8L, new bmlj(8L, 2130844141, alud.a(2131704228)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(512L, new bmlj(512L, 2130846246, alud.a(2131704207)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(4L, new bmlj(4L, 2130844128, alud.a(2131704271)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1048576L, new bmlj(1048576L, 2130846386, alud.a(2131704185)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(32768L, new bmlj(32768L, 2130844140, "GIF快慢"));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(65536L, new bmlj(65536L, 2130846083, "生成GIF"));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(2097152L, new bmlj(2097152L, 2130844140, alud.a(2131704327)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(64L, new bmlj(64L, 2130844130, alud.a(2131704261)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(32L, new bmlj(32L, 2130844127, alud.a(2131704311)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(268435456L, new bmlj(268435456L, 2130844134, alud.a(2131704199)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(16L, new bmlj(16L, 2130844144, alud.a(2131704317)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(33554432L, new bmlj(33554432L, 2130844136, alud.a(2131704297)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1073741824L, new bmlj(1073741824L, 2130844138, "跳转到P图"));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(549755813888L, new bmlj(549755813888L, 2130844126, alud.a(2131704178)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmla
 * JD-Core Version:    0.7.0.1
 */