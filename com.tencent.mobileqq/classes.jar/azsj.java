import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;", "", "type", "", "(I)V", "titleResId", "(II)V", "fieldId", "state", "(IIII)V", "secDescResId", "(IIIII)V", "changed", "", "getChanged", "()Z", "setChanged", "(Z)V", "getFieldId", "()I", "setFieldId", "formItemBgType", "getFormItemBgType", "setFormItemBgType", "getSecDescResId", "setSecDescResId", "getState", "setState", "getTitleResId", "setTitleResId", "getType", "setType", "getBaseVisibleState", "getOtherSwitchState", "toString", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class azsj
{
  private int jdField_a_of_type_Int = -1;
  private boolean jdField_a_of_type_Boolean;
  private int b = -1;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  
  public azsj(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public azsj(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.c = paramInt2;
  }
  
  public azsj(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt4;
    this.e = paramInt3;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final boolean b()
  {
    boolean bool;
    switch (this.e)
    {
    default: 
      bool = true;
    }
    while (azsm.a.a(this.b)) {
      if (!bool)
      {
        return true;
        bool = true;
        continue;
        bool = false;
      }
      else
      {
        return false;
      }
    }
    return bool;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final int d()
  {
    return this.d;
  }
  
  public final void d(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final int e()
  {
    return this.e;
  }
  
  public final int f()
  {
    return this.f;
  }
  
  public final int g()
  {
    switch (this.e)
    {
    default: 
      return 0;
    case 0: 
      return this.e;
    case 1: 
      return this.e;
    }
    return this.e;
  }
  
  @NotNull
  public String toString()
  {
    return "ProfileDisplaySettingItem(type=" + this.jdField_a_of_type_Int + ", fieldId=" + this.b + ", titleResId=" + this.c + ", state=" + this.e + ", changed=" + this.jdField_a_of_type_Boolean + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azsj
 * JD-Core Version:    0.7.0.1
 */