import android.graphics.Path;
import android.view.View;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class atbv
  extends aqyh
{
  public atbv(HeartLayout paramHeartLayout)
  {
    super(paramHeartLayout);
  }
  
  public Path a(int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger, View paramView)
  {
    Random localRandom = this.jdField_a_of_type_JavaUtilRandom;
    Path localPath = new Path();
    label95:
    label107:
    int i;
    int j;
    int k;
    int m;
    if (!this.jdField_a_of_type_Aqyj.jdField_a_of_type_Boolean) {
      if ((paramInt1 < 0) || (paramInt1 > paramView.getWidth()))
      {
        this.jdField_a_of_type_Aqyj.jdField_a_of_type_Int = ((paramView.getWidth() - (int)(20.0F * this.jdField_a_of_type_Aqyj.jdField_a_of_type_Float)) / 2);
        if ((paramInt2 >= 0) && (paramInt2 <= paramView.getHeight())) {
          break label415;
        }
        this.jdField_a_of_type_Aqyj.b = ((int)(20.0F * this.jdField_a_of_type_Aqyj.jdField_a_of_type_Float));
        if (!this.jdField_a_of_type_JavaUtilRandom.nextBoolean()) {
          break label447;
        }
        paramInt1 = 1;
        i = paramInt1 * (localRandom.nextInt(this.jdField_a_of_type_Aqyj.c) + this.jdField_a_of_type_Aqyj.d);
        j = paramInt1 * (localRandom.nextInt(this.jdField_a_of_type_Aqyj.c) + this.jdField_a_of_type_Aqyj.d);
        k = paramView.getHeight() - this.jdField_a_of_type_Aqyj.b;
        paramInt1 = (int)(paramAtomicInteger.intValue() * 4 * this.jdField_a_of_type_Aqyj.jdField_a_of_type_Float);
        paramInt2 = this.jdField_a_of_type_Aqyj.g;
        paramInt2 = localRandom.nextInt(this.jdField_a_of_type_Aqyj.f) + (paramInt1 + paramInt2);
        m = paramInt2 / this.jdField_a_of_type_Aqyj.e;
        paramInt1 = k - paramInt2;
        if (paramInt1 >= 0) {
          break label666;
        }
        paramInt1 = 0;
      }
    }
    label653:
    label666:
    for (;;)
    {
      paramInt2 = k - paramInt2 / 2;
      if (paramInt2 < 0) {
        paramInt2 = 0;
      }
      for (;;)
      {
        localPath.moveTo(this.jdField_a_of_type_Aqyj.jdField_a_of_type_Int, k);
        localPath.cubicTo(this.jdField_a_of_type_Aqyj.jdField_a_of_type_Int, k - m, this.jdField_a_of_type_Aqyj.jdField_a_of_type_Int + i, paramInt2 + m, this.jdField_a_of_type_Aqyj.jdField_a_of_type_Int + i, paramInt2);
        localPath.moveTo(this.jdField_a_of_type_Aqyj.jdField_a_of_type_Int + i, paramInt2);
        if (paramInt2 - m >= 0) {
          localPath.cubicTo(this.jdField_a_of_type_Aqyj.jdField_a_of_type_Int + i, paramInt2 - m, this.jdField_a_of_type_Aqyj.jdField_a_of_type_Int + j, paramInt1 + m, this.jdField_a_of_type_Aqyj.jdField_a_of_type_Int + j, paramInt1);
        }
        return localPath;
        this.jdField_a_of_type_Aqyj.jdField_a_of_type_Int = (paramInt1 - (int)(20.0F * this.jdField_a_of_type_Aqyj.jdField_a_of_type_Float / 3.0F));
        break;
        label415:
        this.jdField_a_of_type_Aqyj.b = (paramView.getHeight() - paramInt2 + (int)(20.0F * this.jdField_a_of_type_Aqyj.jdField_a_of_type_Float / 3.0F));
        break label95;
        label447:
        paramInt1 = -1;
        break label107;
        k = this.jdField_a_of_type_Aqyj.l;
        m = this.jdField_a_of_type_Aqyj.k;
        int n = this.jdField_a_of_type_Aqyj.h / 2;
        int i1;
        int i2;
        int i3;
        int i4;
        if (this.jdField_a_of_type_JavaUtilRandom.nextBoolean())
        {
          i = 1;
          i1 = localRandom.nextInt(this.jdField_a_of_type_Aqyj.c);
          i2 = this.jdField_a_of_type_Aqyj.d;
          i3 = localRandom.nextInt(this.jdField_a_of_type_Aqyj.c);
          i4 = this.jdField_a_of_type_Aqyj.d;
          j = Math.abs(k - paramInt2) / (this.jdField_a_of_type_JavaUtilRandom.nextInt(3) + 2);
          if (k <= paramInt2) {
            break label653;
          }
          j = k - j;
        }
        for (;;)
        {
          localPath.moveTo(paramInt1 - this.jdField_a_of_type_Aqyj.h / 2, paramInt2 - this.jdField_a_of_type_Aqyj.i / 2);
          localPath.cubicTo(i * (i1 + i2) + paramInt1, j, paramInt1 - i * (i3 + i4), j, m - n, k);
          return localPath;
          i = -1;
          break;
          j += k;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atbv
 * JD-Core Version:    0.7.0.1
 */