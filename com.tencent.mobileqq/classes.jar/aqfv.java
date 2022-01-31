import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class aqfv
{
  public static byte[] a;
  double jdField_a_of_type_Double = 0.0D;
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = 1;
  public Context a;
  RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  aqgn jdField_a_of_type_Aqgn = null;
  public QQAppInterface a;
  public List<Face2FaceFriendBubbleView> a;
  Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int = -1;
  List<Integer> jdField_b_of_type_JavaUtilList;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  List<Integer> c;
  public int d;
  List<Integer> d;
  int jdField_e_of_type_Int = 0;
  List<Integer> jdField_e_of_type_JavaUtilList;
  int jdField_f_of_type_Int = -1;
  List<Integer> jdField_f_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(2131366819), Integer.valueOf(2131366821), Integer.valueOf(2131366822), Integer.valueOf(2131366823), Integer.valueOf(2131366824), Integer.valueOf(2131366825), Integer.valueOf(2131366826), Integer.valueOf(2131366827), Integer.valueOf(2131366828), Integer.valueOf(2131366820) });
  int g;
  int h = 0;
  int i = 0;
  int j = 0;
  int k = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[0];
  }
  
  public aqfv(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return (int)(Math.random() * (paramInt2 - paramInt1 + 1) + paramInt1);
  }
  
  public float a(int paramInt1, int paramInt2)
  {
    return (float)(Math.random() * (paramInt2 - paramInt1) + paramInt1);
  }
  
  public Face2FaceFriendBubbleView a(String paramString)
  {
    Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = null;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      localFace2FaceFriendBubbleView = (Face2FaceFriendBubbleView)this.jdField_a_of_type_JavaUtilList.get(((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue());
    }
    return localFace2FaceFriendBubbleView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_d_of_type_JavaUtilList.clear();
    this.jdField_e_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt)
  {
    Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = (Face2FaceFriendBubbleView)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if ((localFace2FaceFriendBubbleView != null) && (localFace2FaceFriendBubbleView.c() != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(localFace2FaceFriendBubbleView.c())))
    {
      this.jdField_a_of_type_JavaUtilMap.remove(localFace2FaceFriendBubbleView.c());
      localFace2FaceFriendBubbleView.setVisibility(4);
      localFace2FaceFriendBubbleView.setStatusWithoutAnimation(1);
      localFace2FaceFriendBubbleView.setClickable(false);
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.a, 2, "removeShowedFriendMap uinToHoleIndex remove( " + localFace2FaceFriendBubbleView.c() + ", " + paramInt + " )");
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    if (paramInt == 1)
    {
      this.jdField_b_of_type_Float = a(45, 180);
      if (a(0, 1) < 0.5D) {
        this.jdField_b_of_type_Float *= -1.0F;
      }
    }
    for (long l = a(800, 1500);; l = 750L)
    {
      RotateAnimation localRotateAnimation = new RotateAnimation(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(l);
      localRotateAnimation.setFillAfter(true);
      localRotateAnimation.setInterpolator(new aqga(this));
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localRotateAnimation);
      localRotateAnimation.setAnimationListener(new aqfy(this, paramInt, paramBoolean));
      return;
    }
  }
  
  public void a(aqgn paramaqgn, boolean paramBoolean)
  {
    if ((paramaqgn == null) || (this.jdField_a_of_type_AndroidContentContext == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendDisappearAnimation disappear data is " + paramaqgn + " mContext " + this.jdField_a_of_type_AndroidContentContext);
      }
      return;
    }
    Object localObject = paramaqgn.e;
    if ((paramaqgn instanceof aqgk)) {
      localObject = paramaqgn.e + "_" + ((aqgk)paramaqgn).b;
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject)) {}
    for (int m = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(localObject)).intValue();; m = -1)
    {
      if (m == -1)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendDisappearAnimation disappear uin " + paramaqgn.e.substring(0, 4) + " is not in the hole");
        QLog.d(Face2FaceAddFriendActivity.b, 2, "startFriendDisappearAnimation disappear uin " + paramaqgn.e.substring(0, 4) + " is not in the hole");
        this.h += 1;
        return;
      }
      localObject = (Face2FaceFriendBubbleView)this.jdField_a_of_type_JavaUtilList.get(m);
      if (paramBoolean)
      {
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.4F, 1.0F, 0.4F, 1, 0.5F, 1, 0.5F);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        AnimationSet localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation(localScaleAnimation);
        localAnimationSet.addAnimation(localAlphaAnimation);
        localAnimationSet.setDuration(1000L);
        localAnimationSet.setFillAfter(true);
        localAnimationSet.setInterpolator(new aqgb(this));
        localAnimationSet.setAnimationListener(new aqfx(this));
        if (localObject != null) {
          ((Face2FaceFriendBubbleView)localObject).startAnimation(localAnimationSet);
        }
      }
      if (localObject == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendDisappearAnimation disappear uin " + paramaqgn.e.substring(0, 4));
      }
      if (this.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(m))) {
        this.jdField_b_of_type_JavaUtilList.remove(Integer.valueOf(m));
      }
      a(m);
      ((Face2FaceAddFriendActivity)this.jdField_a_of_type_AndroidContentContext).c(paramaqgn);
      this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(m));
      if ((m >= 2) && (m <= 7))
      {
        this.jdField_d_of_type_JavaUtilList.add(Integer.valueOf(m));
        return;
      }
      if (((m < 0) || (m > 1)) && ((m < 8) || (m > 9))) {
        break;
      }
      this.jdField_e_of_type_JavaUtilList.add(Integer.valueOf(m));
      return;
    }
  }
  
  public void a(aqgn paramaqgn, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramaqgn == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendInAnimation  data is " + paramaqgn + " mContext " + this.jdField_a_of_type_AndroidContentContext);
      }
    }
    int n;
    int m;
    label91:
    Object localObject1;
    do
    {
      do
      {
        return;
        n = -1;
        if (this.jdField_c_of_type_JavaUtilList.size() != 1) {
          break;
        }
        m = ((Integer)this.jdField_c_of_type_JavaUtilList.get(0)).intValue();
      } while (m == -1);
      localObject1 = (Face2FaceFriendBubbleView)this.jdField_a_of_type_JavaUtilList.get(m);
      this.g = m;
    } while (localObject1 == null);
    this.jdField_a_of_type_Aqgn = paramaqgn;
    ((Face2FaceFriendBubbleView)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaqgn);
    ((Face2FaceFriendBubbleView)localObject1).setVisibility(0);
    ((Face2FaceFriendBubbleView)localObject1).setClickable(true);
    label218:
    Object localObject2;
    int i6;
    int i8;
    int i7;
    int i9;
    int i4;
    int i5;
    label398:
    int i2;
    int i3;
    label459:
    int i1;
    if (QLog.isColorLevel())
    {
      if (!TextUtils.isEmpty(paramaqgn.e)) {
        QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendInAnimation get ( currentUin= " + paramaqgn.e.substring(0, 4) + " , index = " + m + " )");
      }
    }
    else
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_b_of_type_Int = -1;
      localObject2 = new int[2];
      this.jdField_a_of_type_AndroidWidgetImageView.getLocationOnScreen((int[])localObject2);
      i6 = localObject2[0] + (this.jdField_a_of_type_AndroidWidgetImageView.getWidth() >> 1);
      i8 = localObject2[1] + (this.jdField_a_of_type_AndroidWidgetImageView.getHeight() >> 1);
      localObject2 = new int[2];
      ((Face2FaceFriendBubbleView)localObject1).getLocationOnScreen((int[])localObject2);
      i7 = localObject2[0] + (((Face2FaceFriendBubbleView)localObject1).getWidth() >> 1);
      i9 = localObject2[1] + (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1);
      i4 = Math.abs(i6 - i7);
      i5 = Math.abs(i8 - i9);
      this.jdField_a_of_type_Double = (i4 / i5);
      n = ((Face2FaceFriendBubbleView)localObject1).getWidth();
      if (i4 != 0) {
        break label1105;
      }
      n = (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1) + i8;
      if (i9 > i8) {
        n = this.jdField_d_of_type_Int - i8 + (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1);
      }
      i2 = localObject2[0] + ((Face2FaceFriendBubbleView)localObject1).getWidth();
      i3 = n - i5;
      if (i9 > i8) {
        this.jdField_a_of_type_Int = 2;
      }
      if (i7 > i6)
      {
        i2 = this.jdField_c_of_type_Int - localObject2[0];
        if (i9 >= i8) {
          break label1123;
        }
        this.jdField_a_of_type_Int = 5;
      }
      if (n - i8 < ((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1)
      {
        i1 = i3;
        if (n - (this.jdField_d_of_type_Int - i8) < ((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1) {}
      }
      else
      {
        if (i9 >= i8) {
          break label1140;
        }
        i1 = i8 + (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1);
        n = localObject2[1] + ((Face2FaceFriendBubbleView)localObject1).getHeight();
        if (i7 >= i6) {
          break label1132;
        }
        this.jdField_a_of_type_Int = 3;
      }
    }
    for (;;)
    {
      label541:
      i2 = i1 * i4 / i5 - i4;
      i1 = n;
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        n = i2;
        label612:
        double d1 = this.jdField_a_of_type_Double;
        boolean bool = this.jdField_b_of_type_Boolean;
        localObject2 = new TranslateAnimation(n, 0.0F, i1, 0.0F);
        ((TranslateAnimation)localObject2).setDuration(400L);
        ((TranslateAnimation)localObject2).setInterpolator(new aqgb(this));
        ((TranslateAnimation)localObject2).setAnimationListener(new aqfw(this, paramaqgn, m, d1, bool, paramBoolean3, paramaqgn, paramBoolean1, paramBoolean2, (Face2FaceFriendBubbleView)localObject1, paramInt));
        ((Face2FaceFriendBubbleView)localObject1).startAnimation((Animation)localObject2);
        localObject1 = paramaqgn.e;
        if ((paramaqgn instanceof aqgk)) {
          localObject1 = paramaqgn.e + "_" + ((aqgk)paramaqgn).b;
        }
        break;
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilMap.put(localObject1, Integer.valueOf(m));
        ((Face2FaceAddFriendActivity)this.jdField_a_of_type_AndroidContentContext).a(paramaqgn, paramBoolean1, paramBoolean2);
        if (QLog.isColorLevel()) {
          QLog.d(Face2FaceAddFriendActivity.b, 2, "uinToHoleIndex put identify=" + (String)localObject1);
        }
        this.jdField_c_of_type_JavaUtilList.remove(Integer.valueOf(m));
        if (this.jdField_d_of_type_JavaUtilList.contains(Integer.valueOf(m))) {
          this.jdField_d_of_type_JavaUtilList.remove(Integer.valueOf(m));
        }
        while (QLog.isColorLevel())
        {
          QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendInAnimation currentUIn= " + paramaqgn.e.substring(0, 4) + " startAnimation OK");
          return;
          m = n;
          if (this.jdField_c_of_type_JavaUtilList.size() <= 1) {
            break label91;
          }
          if (this.jdField_d_of_type_JavaUtilList.size() == 1)
          {
            m = ((Integer)this.jdField_d_of_type_JavaUtilList.get(0)).intValue();
            break label91;
          }
          if (this.jdField_d_of_type_JavaUtilList.size() > 1)
          {
            m = ((Integer)this.jdField_d_of_type_JavaUtilList.get(a(0, this.jdField_d_of_type_JavaUtilList.size() - 1))).intValue();
            break label91;
          }
          if (this.jdField_e_of_type_JavaUtilList.size() == 0)
          {
            m = ((Integer)this.jdField_e_of_type_JavaUtilList.get(0)).intValue();
            break label91;
          }
          m = n;
          if (this.jdField_e_of_type_JavaUtilList.size() <= 1) {
            break label91;
          }
          m = ((Integer)this.jdField_e_of_type_JavaUtilList.get(a(0, this.jdField_e_of_type_JavaUtilList.size() - 1))).intValue();
          break label91;
          QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendInAnimation get  currentUin= null");
          break label218;
          label1105:
          n = ((n >> 1) + i6) * i5 / i4;
          break label398;
          label1123:
          this.jdField_a_of_type_Int = 6;
          break label459;
          label1132:
          this.jdField_a_of_type_Int = 4;
          break label541;
          label1140:
          if (i9 <= i8) {
            break label1402;
          }
          n = this.jdField_d_of_type_Int;
          i1 = (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1) + (n - i8);
          n = this.jdField_d_of_type_Int - localObject2[1];
          if (i7 < i6)
          {
            this.jdField_a_of_type_Int = 7;
            break label541;
          }
          this.jdField_a_of_type_Int = 8;
          break label541;
          n = -i2;
          i1 = -i1;
          this.jdField_b_of_type_Int = -1;
          this.jdField_b_of_type_Boolean = false;
          break label612;
          n = -i2;
          this.jdField_b_of_type_Int = -1;
          this.jdField_b_of_type_Boolean = true;
          break label612;
          n = -i2;
          i1 = -i1;
          this.jdField_b_of_type_Int = -1;
          this.jdField_b_of_type_Boolean = false;
          break label612;
          i1 = -i1;
          this.jdField_b_of_type_Int = 1;
          this.jdField_b_of_type_Boolean = false;
          n = i2;
          break label612;
          i1 = -i1;
          this.jdField_b_of_type_Int = 1;
          this.jdField_b_of_type_Boolean = false;
          n = i2;
          break label612;
          this.jdField_b_of_type_Int = 1;
          this.jdField_b_of_type_Boolean = true;
          n = i2;
          break label612;
          n = -i2;
          this.jdField_b_of_type_Int = -1;
          this.jdField_b_of_type_Boolean = true;
          break label612;
          this.jdField_b_of_type_Int = 1;
          this.jdField_b_of_type_Boolean = true;
          n = i2;
          break label612;
          if (this.jdField_e_of_type_JavaUtilList.contains(Integer.valueOf(m))) {
            this.jdField_e_of_type_JavaUtilList.remove(Integer.valueOf(m));
          }
        }
      }
      label1402:
      i1 = n;
      n = i3;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, View paramView, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364655));
    if ((paramInt == 1) && (!TextUtils.isEmpty(paramString)))
    {
      ((ImageView)paramView.findViewById(2131364656)).setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839672);
      paramQQAppInterface = paramQQAppInterface.a(paramString, (byte)3, false, false);
      if (paramQQAppInterface != null) {
        break label476;
      }
      paramQQAppInterface = bdda.f();
    }
    label476:
    for (;;)
    {
      paramString = (ImageView)paramView.findViewById(2131378315);
      paramString.setImageBitmap(paramQQAppInterface);
      paramString.setVisibility(0);
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramInt = 0;
      while (paramInt < 10)
      {
        paramQQAppInterface = (Face2FaceFriendBubbleView)paramView.findViewById(((Integer)this.jdField_f_of_type_JavaUtilList.get(paramInt)).intValue());
        paramQQAppInterface.setStatusWithAnimation(1);
        paramQQAppInterface.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_JavaUtilList.add(paramQQAppInterface);
        paramInt += 1;
      }
      this.jdField_b_of_type_JavaUtilList = new LinkedList();
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
      this.jdField_c_of_type_JavaUtilList = new LinkedList();
      this.jdField_c_of_type_JavaUtilList.addAll(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9) }));
      this.jdField_d_of_type_JavaUtilList = new LinkedList();
      this.jdField_d_of_type_JavaUtilList.addAll(Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7) }));
      this.jdField_e_of_type_JavaUtilList = new LinkedList();
      this.jdField_e_of_type_JavaUtilList.addAll(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(8), Integer.valueOf(9) }));
      return;
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (!this.jdField_b_of_type_JavaUtilList.contains(paramString))) {
      this.jdField_b_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilMap.get(paramString));
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    long l = a(800, 1200);
    float f1 = this.jdField_b_of_type_Float;
    int m = (int)a(5, 12);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float - m);
      if (f1 == this.jdField_b_of_type_Float) {
        if (this.jdField_b_of_type_Float <= this.jdField_a_of_type_Float) {
          break label190;
        }
      }
    }
    label190:
    float f2;
    for (this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float - m);; this.jdField_b_of_type_Float = (m + f2))
    {
      this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(f1, this.jdField_b_of_type_Float, 1, 0.5F, 1, 0.5F);
      this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(l);
      this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
      this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setInterpolator(new aqga(this));
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
      this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setAnimationListener(new aqfz(this));
      return;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float + m);
      break;
      f2 = this.jdField_a_of_type_Float;
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      this.jdField_b_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilMap.get(paramString));
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddFriendActivity", 2, "stopCompassShakeAnimation");
    }
    if (this.jdField_a_of_type_AndroidViewAnimationRotateAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.cancel();
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqfv
 * JD-Core Version:    0.7.0.1
 */