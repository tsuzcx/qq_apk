import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;

public class bnns
  extends bnnq
{
  public final int c;
  @NonNull
  public final String c;
  public final int d;
  @NonNull
  public final String d;
  public final int e;
  public final String e;
  public final String f;
  public final String g;
  public final String h;
  public final String i;
  
  @NonNull
  public bnnr a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new bnnt(this, paramContext, paramViewGroup);
  }
  
  @NonNull
  public Class<? extends bnnr> a()
  {
    return bnnt.class;
  }
  
  public String a()
  {
    if ((TextUtils.isEmpty(this.c)) && (TextUtils.isEmpty(this.d)) && (TextUtils.isEmpty(this.e))) {
      return "";
    }
    if ((!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.d))) {
      return this.c + "，" + this.d;
    }
    if (!TextUtils.isEmpty(this.c)) {
      return this.c;
    }
    if (!TextUtils.isEmpty(this.d)) {
      return this.d;
    }
    return this.e;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnns
 * JD-Core Version:    0.7.0.1
 */