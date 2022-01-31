import android.text.TextUtils;
import com.tencent.qqmini.sdk.ui.MoreItem;
import com.tencent.qqmini.sdk.ui.MoreItemList;

public class bhif
{
  private bhig jdField_a_of_type_Bhig = new bhig();
  MoreItemList jdField_a_of_type_ComTencentQqminiSdkUiMoreItemList = new MoreItemList(null);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public bhif a(bhig parambhig)
  {
    this.jdField_a_of_type_Bhig = parambhig;
    return this;
  }
  
  public bhif a(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 1;
    localMoreItem.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bhig.jdField_a_of_type_Boolean;
    localMoreItem.b = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "QQ";
    }
    localMoreItem.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentQqminiSdkUiMoreItemList.add(localMoreItem);
    this.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public final MoreItemList a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      a("QQ", 2130840838);
    }
    if (!this.b) {
      b("QQ空间", 2130840839);
    }
    if (!this.c) {
      c("微信好友", 2130840840);
    }
    if (!this.d) {
      d("微信朋友圈", 2130840841);
    }
    if (!this.e) {
      e("关于", 2130840804);
    }
    if (!this.f) {
      f("举报", 2130840837);
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkUiMoreItemList;
  }
  
  public bhif b(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 2;
    localMoreItem.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bhig.b;
    localMoreItem.b = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "QQ空间";
    }
    localMoreItem.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentQqminiSdkUiMoreItemList.add(localMoreItem);
    this.b = true;
    return this;
  }
  
  public bhif c(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 3;
    localMoreItem.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bhig.c;
    localMoreItem.b = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "微信好友";
    }
    localMoreItem.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentQqminiSdkUiMoreItemList.add(localMoreItem);
    this.c = true;
    return this;
  }
  
  public bhif d(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 4;
    localMoreItem.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bhig.d;
    localMoreItem.b = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "微信朋友圈";
    }
    localMoreItem.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentQqminiSdkUiMoreItemList.add(localMoreItem);
    this.d = true;
    return this;
  }
  
  public bhif e(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 5;
    localMoreItem.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bhig.h;
    localMoreItem.b = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "关于";
    }
    localMoreItem.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentQqminiSdkUiMoreItemList.add(localMoreItem);
    this.e = true;
    return this;
  }
  
  public bhif f(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 6;
    localMoreItem.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bhig.i;
    localMoreItem.b = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "举报";
    }
    localMoreItem.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentQqminiSdkUiMoreItemList.add(localMoreItem);
    this.f = true;
    return this;
  }
  
  public bhif g(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 7;
    localMoreItem.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bhig.f;
    localMoreItem.b = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "调试";
    }
    localMoreItem.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentQqminiSdkUiMoreItemList.add(localMoreItem);
    return this;
  }
  
  public bhif h(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 8;
    localMoreItem.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bhig.g;
    localMoreItem.b = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "性能";
    }
    localMoreItem.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentQqminiSdkUiMoreItemList.add(localMoreItem);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhif
 * JD-Core Version:    0.7.0.1
 */