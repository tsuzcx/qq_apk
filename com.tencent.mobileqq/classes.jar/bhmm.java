import android.text.TextUtils;
import com.tencent.qqmini.sdk.ui.MoreItem;
import com.tencent.qqmini.sdk.ui.MoreItemList;

public class bhmm
{
  private bhmn jdField_a_of_type_Bhmn = new bhmn();
  MoreItemList jdField_a_of_type_ComTencentQqminiSdkUiMoreItemList = new MoreItemList(null);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public bhmm a(bhmn parambhmn)
  {
    this.jdField_a_of_type_Bhmn = parambhmn;
    return this;
  }
  
  public bhmm a(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 1;
    localMoreItem.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bhmn.jdField_a_of_type_Boolean;
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
      a("QQ", 2130840839);
    }
    if (!this.b) {
      b("QQ空间", 2130840840);
    }
    if (!this.c) {
      c("微信好友", 2130840841);
    }
    if (!this.d) {
      d("微信朋友圈", 2130840842);
    }
    if (!this.e) {
      e("关于", 2130840805);
    }
    if (!this.f) {
      f("举报", 2130840838);
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkUiMoreItemList;
  }
  
  public bhmm b(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 2;
    localMoreItem.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bhmn.b;
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
  
  public bhmm c(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 3;
    localMoreItem.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bhmn.c;
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
  
  public bhmm d(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 4;
    localMoreItem.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bhmn.d;
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
  
  public bhmm e(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 5;
    localMoreItem.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bhmn.h;
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
  
  public bhmm f(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 6;
    localMoreItem.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bhmn.i;
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
  
  public bhmm g(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 7;
    localMoreItem.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bhmn.f;
    localMoreItem.b = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "调试";
    }
    localMoreItem.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentQqminiSdkUiMoreItemList.add(localMoreItem);
    return this;
  }
  
  public bhmm h(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 8;
    localMoreItem.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bhmn.g;
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
 * Qualified Name:     bhmm
 * JD-Core Version:    0.7.0.1
 */