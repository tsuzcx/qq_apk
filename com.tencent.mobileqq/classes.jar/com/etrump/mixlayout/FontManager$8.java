package com.etrump.mixlayout;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.qphone.base.util.QLog;

class FontManager$8
  implements Runnable
{
  FontManager$8(FontManager paramFontManager, FriendsManager paramFriendsManager, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_JavaLangString) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> extensionInfo is null.");
      }
      AvatarPendantUtil.a(this.jdField_a_of_type_JavaLangString);
      AvatarPendantUtil.a(FontManager.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.8
 * JD-Core Version:    0.7.0.1
 */