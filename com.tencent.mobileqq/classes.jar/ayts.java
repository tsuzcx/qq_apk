import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"CONSTELLATION_CARD_HEIGHT_DEFAULT", "", "TAG", "", "applyActivityResult", "Lkotlin/Pair;", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "intent", "Landroid/content/Intent;", "currentConstellation", "sendBirthDayChangedRequest", "", "birthday", "age", "constellation", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class ayts
{
  @NotNull
  public static final Pair<Integer, String> a(@NotNull QQAppInterface paramQQAppInterface, @Nullable Intent paramIntent, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Pair localPair = new Pair(Integer.valueOf(0), "");
    int k;
    if (paramIntent != null)
    {
      k = paramIntent.getShortExtra("param_year", (short)1990);
      int m = paramIntent.getByteExtra("param_month", (byte)1);
      int n = paramIntent.getByteExtra("param_day", (byte)1);
      int i = paramIntent.getIntExtra("param_age", 0);
      int j = paramIntent.getIntExtra("param_constellation_id", aysf.b);
      k = k << 16 | m << 8 | n;
      paramIntent = bght.c(j);
      if (QLog.isColorLevel()) {
        QLog.d("ConstellationView", 2, new Object[] { "applyActivityResult: called. ", "constellationStr: " + paramIntent });
      }
      if (!(Intrinsics.areEqual(paramIntent, paramString) ^ true)) {
        break label227;
      }
      a(paramQQAppInterface, k, i, j);
      ayph.a(paramQQAppInterface, paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("ConstellationView", 2, new Object[] { "applyActivityResult: called. ", "constellation: " + paramIntent });
      }
    }
    for (;;)
    {
      localPair = new Pair(Integer.valueOf(k), paramIntent);
      return localPair;
      label227:
      if (QLog.isColorLevel()) {
        QLog.d("ConstellationView", 2, new Object[] { "applyActivityResult: called. ", "not changed, birthdayValue: " + paramString });
      }
    }
  }
  
  public static final void a(@NotNull QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "$this$sendBirthDayChangedRequest");
    Bundle localBundle = new Bundle();
    localBundle.putInt("birthday", paramInt1);
    localBundle.putInt("age", paramInt2);
    localBundle.putInt("key_constellation", paramInt3);
    paramQQAppInterface = paramQQAppInterface.a(2);
    if (paramQQAppInterface == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.CardHandler");
    }
    ((anip)paramQQAppInterface).a(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("ConstellationView", 2, new Object[] { "sendBirthDayChangedRequest: called. ", "constellation: " + paramInt3 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayts
 * JD-Core Version:    0.7.0.1
 */