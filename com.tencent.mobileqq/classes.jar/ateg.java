import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/extendfriend/wiget/FillBirthdayDialog$init$1", "Lcom/tencent/mobileqq/activity/BirthdayPickHelper$BirthdayChangeListener;", "onBirthdayChange", "", "newYear", "", "newMonth", "newDay", "onConfirmBtClicked", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ateg
  implements adzs
{
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ated.a(this.a, paramInt1);
    ated.b(this.a, paramInt2);
    ated.c(this.a, paramInt3);
    ated.d(this.a, paramInt1 << 16 | paramInt2 << 8 | paramInt3);
    if (QLog.isColorLevel())
    {
      Object localObject = StringCompanionObject.INSTANCE;
      localObject = new Object[3];
      localObject[0] = Integer.valueOf(paramInt1);
      localObject[1] = Integer.valueOf(paramInt2);
      localObject[2] = Integer.valueOf(paramInt3);
      localObject = String.format("onBirthdayChange newYear:%d,newMonth:%d,newDay:%d", Arrays.copyOf((Object[])localObject, localObject.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
      QLog.d("FillBirthdayDialog", 2, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ateg
 * JD-Core Version:    0.7.0.1
 */