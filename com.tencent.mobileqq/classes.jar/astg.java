import android.graphics.Path;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class astg
{
  public Handler a;
  public Interpolator a;
  public final asti a;
  private astk a;
  public final Random a;
  public final AtomicInteger a;
  public Interpolator b;
  
  public astg(HeartLayout paramHeartLayout)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_Asti = new asti(paramHeartLayout);
    this.jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new OvershootInterpolator(1.0F);
    this.b = new LinearInterpolator();
  }
  
  public float a()
  {
    return 1.0F * (this.jdField_a_of_type_JavaUtilRandom.nextInt(40) - 20);
  }
  
  public Path a(int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger, View paramView)
  {
    Random localRandom = this.jdField_a_of_type_JavaUtilRandom;
    Path localPath = new Path();
    label87:
    label99:
    int i;
    int j;
    int k;
    int m;
    if (!this.jdField_a_of_type_Asti.jdField_a_of_type_Boolean) {
      if ((paramInt1 < 0) || (paramInt1 > paramView.getWidth()))
      {
        this.jdField_a_of_type_Asti.jdField_a_of_type_Int = ((paramView.getWidth() - this.jdField_a_of_type_Asti.h) / 2);
        if ((paramInt2 >= 0) && (paramInt2 <= paramView.getHeight())) {
          break label402;
        }
        this.jdField_a_of_type_Asti.b = this.jdField_a_of_type_Asti.i;
        if (!this.jdField_a_of_type_JavaUtilRandom.nextBoolean()) {
          break label429;
        }
        paramInt1 = 1;
        i = paramInt1 * (localRandom.nextInt(this.jdField_a_of_type_Asti.c) + this.jdField_a_of_type_Asti.d);
        j = paramInt1 * (localRandom.nextInt(this.jdField_a_of_type_Asti.c) + this.jdField_a_of_type_Asti.d);
        k = paramView.getHeight() - this.jdField_a_of_type_Asti.b;
        paramInt1 = (int)(paramAtomicInteger.intValue() * 4 * this.jdField_a_of_type_Asti.jdField_a_of_type_Float);
        paramInt2 = this.jdField_a_of_type_Asti.g;
        paramInt2 = localRandom.nextInt(this.jdField_a_of_type_Asti.f) + (paramInt1 + paramInt2);
        m = paramInt2 / this.jdField_a_of_type_Asti.e;
        paramInt1 = k - paramInt2;
        if (paramInt1 >= 0) {
          break label648;
        }
        paramInt1 = 0;
      }
    }
    label648:
    for (;;)
    {
      paramInt2 = k - paramInt2 / 2;
      if (paramInt2 < 0) {
        paramInt2 = 0;
      }
      for (;;)
      {
        localPath.moveTo(this.jdField_a_of_type_Asti.jdField_a_of_type_Int, k);
        localPath.cubicTo(this.jdField_a_of_type_Asti.jdField_a_of_type_Int, k - m, this.jdField_a_of_type_Asti.jdField_a_of_type_Int + i, paramInt2 + m, this.jdField_a_of_type_Asti.jdField_a_of_type_Int + i, paramInt2);
        localPath.moveTo(this.jdField_a_of_type_Asti.jdField_a_of_type_Int + i, paramInt2);
        if (paramInt2 - m >= 0) {
          localPath.cubicTo(this.jdField_a_of_type_Asti.jdField_a_of_type_Int + i, paramInt2 - m, this.jdField_a_of_type_Asti.jdField_a_of_type_Int + j, paramInt1 + m, this.jdField_a_of_type_Asti.jdField_a_of_type_Int + j, paramInt1);
        }
        return localPath;
        this.jdField_a_of_type_Asti.jdField_a_of_type_Int = (paramInt1 - this.jdField_a_of_type_Asti.h / 2);
        break;
        label402:
        this.jdField_a_of_type_Asti.b = (paramView.getHeight() - paramInt2 + this.jdField_a_of_type_Asti.h / 2);
        break label87;
        label429:
        paramInt1 = -1;
        break label99;
        k = this.jdField_a_of_type_Asti.l;
        m = this.jdField_a_of_type_Asti.k;
        int n = this.jdField_a_of_type_Asti.h / 2;
        int i1;
        int i2;
        int i3;
        int i4;
        if (this.jdField_a_of_type_JavaUtilRandom.nextBoolean())
        {
          i = 1;
          i1 = localRandom.nextInt(this.jdField_a_of_type_Asti.c);
          i2 = this.jdField_a_of_type_Asti.d;
          i3 = localRandom.nextInt(this.jdField_a_of_type_Asti.c);
          i4 = this.jdField_a_of_type_Asti.d;
          j = Math.abs(k - paramInt2) / (this.jdField_a_of_type_JavaUtilRandom.nextInt(3) + 2);
          if (k <= paramInt2) {
            break label635;
          }
          j = k - j;
        }
        for (;;)
        {
          localPath.moveTo(paramInt1 - this.jdField_a_of_type_Asti.h / 2, paramInt2 - this.jdField_a_of_type_Asti.i / 2);
          localPath.cubicTo(i * (i1 + i2) + paramInt1, j, paramInt1 - i * (i3 + i4), j, m - n, k);
          return localPath;
          i = -1;
          break;
          label635:
          j += k;
        }
      }
    }
  }
  
  public asti a()
  {
    return this.jdField_a_of_type_Asti;
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, ViewGroup paramViewGroup, long paramLong, int paramInt3)
  {
    paramView.setTag(2131373504, Boolean.valueOf(true));
    paramViewGroup.addView(paramView, new ViewGroup.LayoutParams(paramInt1, paramInt2));
    astj localastj = new astj(a((int)paramFloat1, (int)paramFloat2, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, paramViewGroup), a(), paramViewGroup, paramView, this.jdField_a_of_type_Asti);
    if (paramLong > 0L) {}
    for (;;)
    {
      localastj.setDuration(paramLong);
      localastj.setInterpolator(this.b);
      localastj.jdField_a_of_type_Int = paramInt3;
      localastj.jdField_a_of_type_Astk = this.jdField_a_of_type_Astk;
      localastj.jdField_a_of_type_AndroidViewAnimationInterpolator = this.jdField_a_of_type_AndroidViewAnimationInterpolator;
      localastj.setAnimationListener(new asth(this, paramViewGroup, paramView));
      paramView.startAnimation(localastj);
      return;
      paramLong = this.jdField_a_of_type_Asti.j;
    }
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2, ViewGroup paramViewGroup)
  {
    a(paramView, paramFloat1, paramFloat2, paramViewGroup, -1L, 0);
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2, ViewGroup paramViewGroup, long paramLong, int paramInt)
  {
    a(paramView, paramFloat1, paramFloat2, this.jdField_a_of_type_Asti.h, this.jdField_a_of_type_Asti.i, paramViewGroup, paramLong, paramInt);
  }
  
  public void a(astk paramastk)
  {
    this.jdField_a_of_type_Astk = paramastk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astg
 * JD-Core Version:    0.7.0.1
 */