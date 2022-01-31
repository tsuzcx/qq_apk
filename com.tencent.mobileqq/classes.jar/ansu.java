import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleNewAIOAnim.1;
import com.tencent.mobileqq.bubble.BubbleNewAIOAnim.3;
import com.tencent.mobileqq.bubble.BubbleNewAIOAnim.7;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(11)
public class ansu
  extends aepy
{
  public long a;
  public aelt a;
  public AnimatorSet a;
  private final Resources jdField_a_of_type_AndroidContentResResources;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  public View a;
  public anrz a;
  public ansc a;
  private ansz jdField_a_of_type_Ansz;
  public QQAppInterface a;
  public BubbleManager a;
  public String a;
  public ArrayList<antb> a;
  public ConcurrentHashMap<String, Bitmap> a;
  public boolean a;
  public int b;
  public View b;
  public String b;
  private boolean b;
  public int c;
  public View c;
  public int d;
  public View d;
  public int e;
  public View e;
  public int f;
  public int g;
  public int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n = -1;
  
  public ansu(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentResResources = paramListView.getResources();
    this.jdField_h_of_type_Int = aekt.a(12.0F, paramListView.getContext().getResources());
    this.k = aekt.a(50.0F, paramListView.getContext().getResources());
    this.l = aekt.a(45.0F, paramListView.getContext().getResources());
  }
  
  private int a(float paramFloat)
  {
    int i1 = Math.abs(this.jdField_e_of_type_Int - this.jdField_d_of_type_Int);
    if (paramFloat == 0.1F)
    {
      if (this.jdField_a_of_type_Boolean) {}
      for (i1 = this.jdField_e_of_type_Int - this.jdField_h_of_type_Int;; i1 = this.jdField_d_of_type_Int + this.jdField_h_of_type_Int) {
        return i1 - this.i / 2;
      }
    }
    if (paramFloat == 0.9F)
    {
      if (this.jdField_a_of_type_Boolean) {}
      for (paramFloat = this.jdField_d_of_type_Int + this.jdField_h_of_type_Int;; paramFloat = this.jdField_e_of_type_Int - this.jdField_h_of_type_Int)
      {
        i1 = (int)paramFloat;
        break;
      }
    }
    paramFloat = i1 * paramFloat;
    if (this.jdField_a_of_type_Boolean) {}
    for (paramFloat = this.jdField_e_of_type_Int - paramFloat;; paramFloat += this.jdField_d_of_type_Int)
    {
      i1 = (int)paramFloat;
      break;
    }
  }
  
  private int a(Animator paramAnimator, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i1 = 0;
      if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        if (!((antb)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString.equals(paramString)) {}
      }
      for (;;)
      {
        if (i1 != -1)
        {
          paramString = (antb)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if (!(paramString instanceof antd)) {
            break label113;
          }
        }
        label113:
        for (paramString = f((antd)paramString);; paramString = null)
        {
          if ((paramAnimator != null) && (paramString != null))
          {
            paramString.setDuration(paramAnimator.getDuration());
            paramAnimator.addListener(new answ(this, paramString));
          }
          return i1;
          i1 += 1;
          break;
        }
        i1 = -1;
      }
    }
    return -1;
  }
  
  private ObjectAnimator a(antd paramantd)
  {
    if (paramantd == null) {
      return null;
    }
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false), this.jdField_a_of_type_Anrz.jdField_a_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    if (i1 < paramantd.jdField_b_of_type_Int)
    {
      String str = localFile.getAbsolutePath() + File.separatorChar + paramantd.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i1 + 1) });
      ansz localansz = new ansz();
      localansz.jdField_b_of_type_JavaLangString = str;
      localansz.jdField_a_of_type_JavaLangString = (paramantd.jdField_a_of_type_JavaLangString + str);
      boolean bool;
      if (this.jdField_a_of_type_Boolean) {
        bool = paramantd.jdField_b_of_type_Boolean;
      }
      for (;;)
      {
        localansz.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        localArrayList.add(localansz);
        i1 += 1;
        break;
        if (!paramantd.jdField_b_of_type_Boolean) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
    return a(localArrayList);
  }
  
  private ObjectAnimator a(ante paramante)
  {
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false), this.jdField_a_of_type_Anrz.jdField_a_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    if (i1 < paramante.jdField_b_of_type_Int)
    {
      String str = localFile.getAbsolutePath() + File.separatorChar + paramante.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i1 + 1) });
      ansz localansz = new ansz();
      localansz.jdField_b_of_type_JavaLangString = str;
      localansz.jdField_a_of_type_JavaLangString = (paramante.jdField_a_of_type_JavaLangString + str);
      if (this.jdField_a_of_type_Boolean) {}
      for (boolean bool = false;; bool = true)
      {
        localansz.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        localArrayList.add(localansz);
        i1 += 1;
        break;
      }
    }
    return b(localArrayList);
  }
  
  private ObjectAnimator a(List<ansz> paramList)
  {
    if (paramList.size() <= 0) {
      return null;
    }
    Object localObject = new Keyframe[paramList.size() + 1];
    float f1 = 1.0F / paramList.size();
    localObject[0] = Keyframe.ofObject(0.0F, this.jdField_a_of_type_Ansz);
    int i1 = 0;
    if (i1 < paramList.size())
    {
      if (i1 != paramList.size() - 1) {
        localObject[(i1 + 1)] = Keyframe.ofObject((i1 + 1) * f1, paramList.get(i1));
      }
      for (;;)
      {
        i1 += 1;
        break;
        localObject[(i1 + 1)] = Keyframe.ofObject(1.0F, paramList.get(i1));
      }
    }
    localObject = PropertyValuesHolder.ofKeyframe("bitmapData", (Keyframe[])localObject);
    ((PropertyValuesHolder)localObject).setEvaluator(new anta(this));
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localObject }).setDuration(paramList.size() * 125);
  }
  
  private Interpolator a(antd paramantd)
  {
    switch (paramantd.jdField_e_of_type_Int)
    {
    case 0: 
    default: 
      return null;
    case 1: 
      return new AccelerateInterpolator();
    }
    return new DecelerateInterpolator();
  }
  
  private int b(float paramFloat)
  {
    int i1 = Math.abs(this.jdField_f_of_type_Int - this.jdField_g_of_type_Int);
    if (paramFloat == 0.1F) {
      i1 = this.jdField_f_of_type_Int + this.jdField_h_of_type_Int;
    }
    for (;;)
    {
      return i1 - this.j / 2;
      if (paramFloat == 0.9F)
      {
        i1 = this.jdField_g_of_type_Int - this.jdField_h_of_type_Int;
      }
      else
      {
        float f1 = this.jdField_f_of_type_Int;
        i1 = (int)(i1 * paramFloat + f1);
      }
    }
  }
  
  private ObjectAnimator b(antd paramantd)
  {
    int i2 = a(paramantd.jdField_a_of_type_Float);
    int i3 = b(paramantd.jdField_b_of_type_Float);
    int i4 = a(paramantd.jdField_c_of_type_Float);
    int i5 = b(paramantd.d);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i1 = 1;; i1 = -1)
    {
      Object localObject = new ArrayList();
      antr localantr = antr.b(i2, i3);
      localantr.jdField_c_of_type_Float = (paramantd.jdField_h_of_type_Int * i1);
      localantr.d = (paramantd.jdField_f_of_type_Int / 100.0F);
      ((ArrayList)localObject).add(localantr);
      localantr = antr.a(i4, i5);
      localantr.jdField_c_of_type_Float = (i1 * paramantd.i);
      localantr.d = (paramantd.jdField_g_of_type_Int / 100.0F);
      ((ArrayList)localObject).add(localantr);
      localObject = ObjectAnimator.ofObject(this, "pathLocation", new ants(), ((ArrayList)localObject).toArray());
      ((ObjectAnimator)localObject).setInterpolator(a(paramantd));
      ((ObjectAnimator)localObject).setDuration(((Math.abs(i2 - i4) + Math.abs(i3 - i5)) * 1.0F / this.k * (float)paramantd.jdField_a_of_type_Long));
      return localObject;
    }
  }
  
  private ObjectAnimator b(ante paramante)
  {
    ObjectAnimator localObjectAnimator = a(paramante);
    if (localObjectAnimator != null) {
      localObjectAnimator.addListener(new ansy(this, paramante));
    }
    return localObjectAnimator;
  }
  
  private ObjectAnimator b(List<ansz> paramList)
  {
    if (paramList.size() <= 0) {
      return null;
    }
    Object localObject = new Keyframe[paramList.size() + 1];
    float f1 = 1.0F / paramList.size();
    localObject[0] = Keyframe.ofObject(0.0F, this.jdField_a_of_type_Ansz);
    int i1 = 0;
    if (i1 < paramList.size())
    {
      if (i1 != paramList.size() - 1) {
        localObject[(i1 + 1)] = Keyframe.ofObject((i1 + 1) * f1, paramList.get(i1));
      }
      for (;;)
      {
        i1 += 1;
        break;
        localObject[(i1 + 1)] = Keyframe.ofObject(1.0F, paramList.get(i1));
      }
    }
    localObject = PropertyValuesHolder.ofKeyframe("pendantBitmap", (Keyframe[])localObject);
    ((PropertyValuesHolder)localObject).setEvaluator(new anta(this));
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localObject }).setDuration(paramList.size() * 125);
  }
  
  private ObjectAnimator c(antd paramantd)
  {
    int i2 = a(paramantd.jdField_a_of_type_Float);
    int i3 = b(paramantd.jdField_b_of_type_Float);
    int i4 = a(paramantd.jdField_c_of_type_Float);
    int i5 = b(paramantd.d);
    int i6 = a(paramantd.jdField_e_of_type_Float);
    int i7 = b(paramantd.jdField_f_of_type_Float);
    int i8 = a(paramantd.jdField_g_of_type_Float);
    int i9 = b(paramantd.jdField_h_of_type_Float);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i1 = 1;; i1 = -1)
    {
      Object localObject = new ArrayList();
      antr localantr = antr.b(i2, i3);
      localantr.d = paramantd.jdField_f_of_type_Int;
      localantr.jdField_c_of_type_Float = (paramantd.jdField_h_of_type_Int * i1);
      ((ArrayList)localObject).add(localantr);
      localantr = antr.a(i6, i7, i8, i9, i4, i5);
      a("play circle points: " + antr.a(i6, i7, i8, i9, i4, i5).toString());
      localantr.jdField_c_of_type_Float = (paramantd.i * i1);
      localantr.d = (paramantd.jdField_g_of_type_Int / 100.0F);
      ((ArrayList)localObject).add(localantr);
      localObject = ObjectAnimator.ofObject(this, "pathLocation", new ants(), ((ArrayList)localObject).toArray());
      ((ObjectAnimator)localObject).setInterpolator(a(paramantd));
      ((ObjectAnimator)localObject).setDuration(((Math.abs(i2 - i4) + Math.abs(i3 - i5)) * 1.0F / this.k * (float)paramantd.jdField_a_of_type_Long * 3.141592653589793D * 0.4000000059604645D));
      return localObject;
    }
  }
  
  private ObjectAnimator d(antd paramantd)
  {
    int i3 = a(paramantd.jdField_a_of_type_Float);
    int i4 = b(paramantd.jdField_b_of_type_Float);
    int i2 = a(paramantd.jdField_c_of_type_Float);
    if (i4 != b(paramantd.d)) {
      return null;
    }
    int i1;
    int i5;
    int i6;
    if (i2 > i3)
    {
      i1 = 1;
      i5 = this.k;
      i5 = paramantd.j * i5;
      i6 = Math.abs(i3 - i2);
      i2 = (int)(Math.abs(i3 - i2) * 1.0F / i5 + 0.5F);
      if (i2 != 0) {
        break label558;
      }
      i2 = 1;
    }
    label558:
    for (;;)
    {
      a("playPeriodicalCircleAnim, periodLen: " + i5 + ", period: " + i2 + ", resize periodLen: " + i6 / i2);
      i5 = i6 / i2;
      i6 = (int)(i3 + i5 * paramantd.jdField_e_of_type_Float * i1);
      int i7 = (int)(i4 + i5 * paramantd.jdField_f_of_type_Float);
      int i8 = (int)(i3 + i5 * paramantd.jdField_g_of_type_Float * i1);
      int i9 = (int)(i4 + i5 * paramantd.jdField_h_of_type_Float);
      int i10 = i3 + i5 * i1;
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(antr.b(i3, i4));
      ((ArrayList)localObject).add(antr.a(i6, i7, i8, i9, i10, i4));
      a("next points: " + antr.a(i6, i7, i8, i9, i10, i4).toString());
      i3 = 1;
      for (;;)
      {
        if (i3 < i2)
        {
          int i11 = i1 * i3 * i5 + i6;
          int i12 = i1 * i3 * i5 + i8;
          int i13 = i1 * i3 * i5 + i10;
          ((ArrayList)localObject).add(antr.a(i11, i7, i12, i9, i13, i4));
          a("next points: " + antr.a(i11, i7, i12, i9, i13, i4).toString());
          i3 += 1;
          continue;
          i1 = -1;
          break;
        }
      }
      localObject = ObjectAnimator.ofObject(this, "pathLocation", new ants(), ((ArrayList)localObject).toArray());
      ((ObjectAnimator)localObject).setInterpolator(a(paramantd));
      a("duration: " + paramantd.jdField_a_of_type_Long * i2 * 3.141592653589793D * 0.4000000059604645D);
      ((ObjectAnimator)localObject).setDuration((paramantd.jdField_a_of_type_Long * i2 * 3.141592653589793D * 0.4000000059604645D));
      return localObject;
    }
  }
  
  private ObjectAnimator e(antd paramantd)
  {
    int i1 = a(paramantd.jdField_a_of_type_Float);
    int i2 = b(paramantd.jdField_b_of_type_Float);
    int i3 = a(paramantd.jdField_c_of_type_Float);
    int i4 = b(paramantd.d);
    if ((i1 == i3) || (i2 == i4)) {
      if (i2 == i4) {
        i1 = 1;
      }
    }
    while (i1 != 0)
    {
      return d(paramantd);
      i1 = 0;
      continue;
      return null;
    }
    return null;
  }
  
  private void e()
  {
    ViewGroup localViewGroup;
    int i1;
    if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView instanceof ViewGroup)))
    {
      localViewGroup = (ViewGroup)this.jdField_b_of_type_AndroidViewView;
      i1 = 0;
    }
    for (;;)
    {
      if (i1 < localViewGroup.getChildCount())
      {
        View localView = localViewGroup.getChildAt(i1);
        if ((localView.getId() == 2131364191) && (localView.getVisibility() == 0))
        {
          this.jdField_e_of_type_AndroidViewView = localView;
          this.jdField_d_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
          this.jdField_d_of_type_AndroidViewView.layout(0, 0, aekt.a(50.0F, this.jdField_a_of_type_AndroidContentResResources), aekt.a(59.0F, this.jdField_a_of_type_AndroidContentResResources));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView(this.jdField_d_of_type_AndroidViewView);
        }
      }
      else
      {
        return;
      }
      i1 += 1;
    }
  }
  
  private ObjectAnimator f(antd paramantd)
  {
    ObjectAnimator localObjectAnimator1;
    if ((paramantd.jdField_e_of_type_Float == 0.0F) && (paramantd.jdField_f_of_type_Float == 0.0F) && (paramantd.jdField_g_of_type_Float == 0.0F) && (paramantd.jdField_h_of_type_Float == 0.0F)) {
      localObjectAnimator1 = b(paramantd);
    }
    ObjectAnimator localObjectAnimator2;
    for (;;)
    {
      localObjectAnimator2 = a(paramantd);
      if ((localObjectAnimator1 != null) && (localObjectAnimator2 != null)) {
        break;
      }
      return null;
      if (paramantd.jdField_c_of_type_Boolean) {
        localObjectAnimator1 = e(paramantd);
      } else {
        localObjectAnimator1 = c(paramantd);
      }
    }
    int i1;
    if ((paramantd.jdField_a_of_type_Float == paramantd.jdField_c_of_type_Float) && (paramantd.jdField_b_of_type_Float == paramantd.d))
    {
      localObjectAnimator1.setDuration(localObjectAnimator2.getDuration());
      if (paramantd.jdField_a_of_type_Int - 1 >= 0)
      {
        i1 = paramantd.jdField_a_of_type_Int - 1;
        localObjectAnimator1.setRepeatCount(i1);
      }
    }
    for (;;)
    {
      localObjectAnimator1.addListener(new ansx(this, localObjectAnimator2));
      return localObjectAnimator1;
      i1 = 0;
      break;
      localObjectAnimator2.setRepeatCount(-1);
    }
  }
  
  private void f()
  {
    this.jdField_d_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getLeft() + BaseChatItemLayout.i);
    this.jdField_e_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getRight() - BaseChatItemLayout.i);
    this.jdField_f_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getTop() + BaseChatItemLayout.jdField_g_of_type_Int);
    this.jdField_g_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getBottom() - BaseChatItemLayout.jdField_h_of_type_Int);
    this.jdField_f_of_type_Int += this.jdField_a_of_type_Anrz.jdField_h_of_type_Int / 2;
    this.jdField_g_of_type_Int -= this.jdField_a_of_type_Anrz.i / 2;
    this.jdField_d_of_type_Int += this.jdField_a_of_type_Anrz.jdField_f_of_type_Int / 2;
    this.jdField_e_of_type_Int -= this.jdField_a_of_type_Anrz.jdField_g_of_type_Int / 2;
    if (this.jdField_g_of_type_Int <= this.jdField_f_of_type_Int)
    {
      this.jdField_f_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getTop() + BaseChatItemLayout.jdField_g_of_type_Int);
      this.jdField_g_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getBottom() - BaseChatItemLayout.jdField_h_of_type_Int);
    }
    if (this.jdField_e_of_type_Int <= this.jdField_d_of_type_Int)
    {
      this.jdField_d_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getLeft() + BaseChatItemLayout.i);
      this.jdField_e_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getRight() - BaseChatItemLayout.i);
    }
    if (this.jdField_b_of_type_Int == 160)
    {
      this.jdField_d_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getLeft() + BaseChatItemLayout.i - this.i / 3);
      this.jdField_e_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getRight() - BaseChatItemLayout.i + this.i / 3);
      this.jdField_f_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getTop() + BaseChatItemLayout.jdField_g_of_type_Int - this.j / 3);
      this.jdField_g_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getBottom() - BaseChatItemLayout.jdField_h_of_type_Int + this.j / 3);
    }
  }
  
  private void g()
  {
    boolean bool = false;
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject1 = (antb)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (!(localObject1 instanceof antd)) {}
    }
    for (Object localObject1 = (antd)localObject1;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        return;
        i1 += 1;
        break;
      }
      Object localObject2 = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false), this.jdField_a_of_type_Anrz.jdField_a_of_type_JavaLangString);
      localObject2 = ((File)localObject2).getAbsolutePath() + File.separatorChar + ((antd)localObject1).jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(1) });
      Object localObject3 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
      BubbleManager.a((String)localObject2, (BitmapFactory.Options)localObject3);
      this.i = bdal.a(((BitmapFactory.Options)localObject3).outWidth, 320, this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi);
      this.j = bdal.a(((BitmapFactory.Options)localObject3).outHeight, 320, this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi);
      if (this.i > BaseChatItemLayout.i * 2)
      {
        i1 = BaseChatItemLayout.i * 2;
        this.j = ((int)(this.j * i1 * 1.0F / this.i));
        this.i = i1;
      }
      localObject3 = new View(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
      ((View)localObject3).layout(0, 0, this.i, this.j);
      ((View)localObject3).setVisibility(4);
      this.jdField_a_of_type_Ansz = new ansz();
      this.jdField_a_of_type_Ansz.jdField_b_of_type_JavaLangString = ((String)localObject2);
      this.jdField_a_of_type_Ansz.jdField_a_of_type_JavaLangString = (((antd)localObject1).jdField_a_of_type_JavaLangString + (String)localObject2);
      localObject2 = this.jdField_a_of_type_Ansz;
      if (this.jdField_a_of_type_Boolean) {
        bool = ((antd)localObject1).jdField_b_of_type_Boolean;
      }
      for (;;)
      {
        ((ansz)localObject2).jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView((View)localObject3);
        this.jdField_c_of_type_AndroidViewView = ((View)localObject3);
        return;
        if (!((antd)localObject1).jdField_b_of_type_Boolean) {
          bool = true;
        }
      }
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    int i1;
    if (this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition() == 0)
    {
      i1 = 0;
      if (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label328;
      }
      localObject = (antb)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (!(localObject instanceof antd)) {
        break label134;
      }
    }
    label134:
    label273:
    label319:
    label328:
    for (Object localObject = (antd)localObject;; localObject = null)
    {
      localObject = a((antd)localObject);
      if (localObject != null)
      {
        ((ObjectAnimator)localObject).setDuration(200L);
        localArrayList.add(localObject);
      }
      int i2 = 0;
      i1 = -1;
      int i3;
      for (;;)
      {
        if (i2 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          if (i2 == i1)
          {
            i3 = i1;
            i2 += 1;
            i1 = i3;
            continue;
            i1 += 1;
            break;
          }
          localObject = (antb)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
          if ((localObject instanceof antd)) {
            localObject = f((antd)localObject);
          }
        }
      }
      for (;;)
      {
        i3 = i1;
        if (localObject == null) {
          break;
        }
        localArrayList.add(localObject);
        i3 = i1;
        break;
        if ((localObject instanceof ante))
        {
          ante localante = (ante)localObject;
          localObject = b(localante);
          if (localObject != null) {
            if (localante.jdField_a_of_type_Int - 1 < 0) {
              break label273;
            }
          }
          for (i3 = localante.jdField_a_of_type_Int - 1;; i3 = 0)
          {
            ((ObjectAnimator)localObject).setRepeatCount(i3);
            if (TextUtils.isEmpty(localante.e)) {
              break label319;
            }
            i1 = a((Animator)localObject, localante.e);
            break;
          }
          this.jdField_a_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
          this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new ansv(this));
          this.jdField_a_of_type_AndroidOsHandler.post(new BubbleNewAIOAnim.3(this));
          return;
        }
        else
        {
          localObject = null;
        }
      }
    }
  }
  
  private void i()
  {
    ThreadManager.post(new BubbleNewAIOAnim.7(this), 5, null, true);
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setTranslationY(this.jdField_c_of_type_AndroidViewView.getTranslationY() + paramInt);
    }
    if ((this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView != null))
    {
      paramInt = (int)(this.jdField_d_of_type_AndroidViewView.getTranslationY() + paramInt);
      this.jdField_d_of_type_AndroidViewView.setTranslationY(paramInt);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleNewAIOAnim", 4, paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean == paramBoolean) {}
    Object localObject;
    label90:
    for (;;)
    {
      return;
      this.jdField_b_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_Aelt != null)
      {
        if (this.jdField_a_of_type_Aelt.jdField_a_of_type_Ansf != null) {}
        for (localObject = this.jdField_a_of_type_Aelt.jdField_a_of_type_Ansf.a;; localObject = null)
        {
          if ((localObject == null) || (!this.jdField_a_of_type_Anrz.jdField_b_of_type_Boolean)) {
            break label90;
          }
          localObject = this.jdField_a_of_type_Aelt.jdField_a_of_type_AndroidViewView.getBackground();
          if (!(localObject instanceof anty)) {
            break;
          }
          if (!paramBoolean) {
            break label92;
          }
          ((anty)localObject).c(true);
          return;
        }
      }
    }
    label92:
    ((anty)localObject).c(false);
  }
  
  protected boolean a(int paramInt)
  {
    return true;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_c_of_type_Int = aekt.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
    Object localObject1 = aekt.a(aekt.a(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_c_of_type_Int));
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof aelt)))
    {
      this.jdField_a_of_type_Aelt = ((aelt)localObject1);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Aelt.jdField_a_of_type_AndroidViewView;
      this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
      if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView instanceof ViewGroup)))
      {
        localObject2 = (ViewGroup)this.jdField_b_of_type_AndroidViewView;
        paramInt1 = 0;
        if (paramInt1 < ((ViewGroup)localObject2).getChildCount())
        {
          View localView = ((ViewGroup)localObject2).getChildAt(paramInt1);
          if (localView.getId() != 2131364191) {
            break label193;
          }
          this.jdField_e_of_type_AndroidViewView = localView;
        }
      }
      label143:
      localObject2 = new StringBuilder().append("relayout children,  p : ").append(this.jdField_c_of_type_Int).append(", get object: ");
      if (localObject1 == null) {
        break label207;
      }
    }
    label193:
    label207:
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(paramBoolean);
      return false;
      paramInt1 += 1;
      break;
      c();
      break label143;
    }
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    if ((this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_a_of_type_AndroidAnimationAnimatorSet.isRunning())) {
      return false;
    }
    if (!bhou.e()) {
      return false;
    }
    this.n = ((Integer)paramVarArgs[0]).intValue();
    this.jdField_a_of_type_Long = ((Long)paramVarArgs[1]).longValue();
    this.jdField_b_of_type_Int = ((Integer)paramVarArgs[2]).intValue();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramVarArgs[3]);
    a("start msg id " + this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager = ((BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44));
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager == null) || (this.jdField_a_of_type_Long == 0L)) {
      return false;
    }
    this.jdField_a_of_type_Ansc = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false);
    if (this.jdField_a_of_type_Ansc == null) {
      return false;
    }
    this.jdField_a_of_type_Anrz = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, this.n);
    if (this.jdField_a_of_type_Anrz == null) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_Anrz.jdField_a_of_type_JavaUtilArrayList;
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      return false;
    }
    this.jdField_c_of_type_Int = aekt.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
    paramVarArgs = aekt.a(aekt.a(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_c_of_type_Int));
    if ((paramVarArgs != null) && ((paramVarArgs instanceof aelt)))
    {
      this.jdField_a_of_type_Aelt = ((aelt)paramVarArgs);
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Aelt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend();
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Aelt.jdField_a_of_type_AndroidViewView;
      this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
      this.m = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth();
      i();
      g();
      f();
      e();
      h();
      return true;
    }
    return false;
  }
  
  protected void c()
  {
    a("now stop new bubble animation conf!");
    this.jdField_a_of_type_AndroidOsHandler.post(new BubbleNewAIOAnim.1(this));
  }
  
  public void setBitmapData(ansz paramansz)
  {
    if (paramansz == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_c_of_type_AndroidViewView == null))
          {
            c();
            return;
          }
        } while (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramansz.jdField_a_of_type_JavaLangString));
        if (paramansz.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          localObject = new ansb(paramansz.jdField_a_of_type_AndroidGraphicsBitmap);
          ((ansb)localObject).jdField_a_of_type_Boolean = paramansz.jdField_a_of_type_JavaLangBoolean.booleanValue();
          this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
          this.jdField_a_of_type_JavaLangString = paramansz.jdField_a_of_type_JavaLangString;
          a("set bitmap path:" + paramansz.jdField_a_of_type_JavaLangString);
          this.jdField_c_of_type_AndroidViewView.invalidate();
          return;
        }
      } while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramansz.jdField_a_of_type_JavaLangString));
      a("get cache bitmap path:" + paramansz.jdField_a_of_type_JavaLangString);
      localObject = (Bitmap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramansz.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    Object localObject = new ansb((Bitmap)localObject);
    ((ansb)localObject).jdField_a_of_type_Boolean = paramansz.jdField_a_of_type_JavaLangBoolean.booleanValue();
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_JavaLangString = paramansz.jdField_a_of_type_JavaLangString;
    this.jdField_c_of_type_AndroidViewView.invalidate();
  }
  
  public void setPathLocation(antr paramantr)
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_c_of_type_AndroidViewView == null))
    {
      c();
      return;
    }
    this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth();
    if (this.jdField_a_of_type_Boolean) {
      f1 = paramantr.jdField_a_of_type_Float;
    }
    float f2;
    for (float f1 = i1 - this.m + f1;; f1 = paramantr.jdField_a_of_type_Float)
    {
      f2 = paramantr.jdField_b_of_type_Float + this.jdField_b_of_type_AndroidViewView.getTop() - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
      if (f2 >= this.jdField_a_of_type_ComTencentWidgetListView.getTop() - this.jdField_c_of_type_AndroidViewView.getHeight()) {
        break;
      }
      a("setPathLocation: now scroll over sreen, stop bubble animatorset!");
      a("now listview firstVisible postion: " + this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition() + ", last postion: " + this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition() + ", now msg pos: " + this.jdField_c_of_type_Int);
      c();
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setTranslationX(f1);
    this.jdField_c_of_type_AndroidViewView.setTranslationY(f2);
    this.jdField_c_of_type_AndroidViewView.setAlpha(paramantr.d);
    this.jdField_c_of_type_AndroidViewView.setRotation(paramantr.jdField_c_of_type_Float);
  }
  
  public void setPendantBitmap(ansz paramansz)
  {
    if (paramansz == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_d_of_type_AndroidViewView == null) || (this.jdField_e_of_type_AndroidViewView == null))
          {
            c();
            return;
          }
          int i1 = this.jdField_e_of_type_AndroidViewView.getLeft();
          this.jdField_d_of_type_AndroidViewView.setTranslationX(i1);
          i1 = this.jdField_e_of_type_AndroidViewView.getTop();
          int i2 = this.jdField_b_of_type_AndroidViewView.getTop();
          int i3 = this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
          this.jdField_d_of_type_AndroidViewView.setTranslationY(i1 + i2 - i3);
          if ((this.jdField_c_of_type_Int > this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition()) || (this.jdField_c_of_type_Int < this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition()))
          {
            a("setPendantBitmap: now scroll over sreen, stop pendant animatorset!");
            c();
            return;
          }
        } while (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(paramansz.jdField_a_of_type_JavaLangString));
        if (paramansz.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          localObject = new ansb(paramansz.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_b_of_type_JavaLangString = paramansz.jdField_a_of_type_JavaLangString;
          ((ansb)localObject).jdField_a_of_type_Boolean = paramansz.jdField_a_of_type_JavaLangBoolean.booleanValue();
          this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
          this.jdField_d_of_type_AndroidViewView.invalidate();
          return;
        }
      } while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramansz.jdField_a_of_type_JavaLangString));
      localObject = (Bitmap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramansz.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    Object localObject = new ansb((Bitmap)localObject);
    this.jdField_b_of_type_JavaLangString = paramansz.jdField_a_of_type_JavaLangString;
    ((ansb)localObject).jdField_a_of_type_Boolean = paramansz.jdField_a_of_type_JavaLangBoolean.booleanValue();
    this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_d_of_type_AndroidViewView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansu
 * JD-Core Version:    0.7.0.1
 */