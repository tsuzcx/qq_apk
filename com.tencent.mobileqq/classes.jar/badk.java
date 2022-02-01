import android.graphics.PointF;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "measuredWidth", "", "measuredHeight", "onMeasured", "com/tencent/mobileqq/profilecard/vas/component/background/VasProfileSimpleBackgroundComponent$updateDiyText$1$1"}, k=3, mv={1, 1, 16})
final class badk
  implements afkl
{
  badk(badj parambadj) {}
  
  public final void a(int paramInt1, int paramInt2)
  {
    Object localObject = badj.a(this.a);
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((SingleTouchLayout)localObject).setActualViewSize(paramInt1, paramInt2);
    localObject = badj.a(this.a);
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((SingleTouchLayout)localObject).invalidate();
    if (QLog.isColorLevel())
    {
      localObject = this.a.b();
      StringBuilder localStringBuilder = new StringBuilder().append("updateDiyText: x=");
      SingleTouchLayout localSingleTouchLayout = badj.a(this.a);
      if (localSingleTouchLayout == null) {
        Intrinsics.throwNpe();
      }
      localStringBuilder = localStringBuilder.append(localSingleTouchLayout.a().x).append(',').append("y=");
      localSingleTouchLayout = badj.a(this.a);
      if (localSingleTouchLayout == null) {
        Intrinsics.throwNpe();
      }
      QLog.d((String)localObject, 2, localSingleTouchLayout.a().y + ',' + "width=" + paramInt1 + ',' + "height=" + paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badk
 * JD-Core Version:    0.7.0.1
 */