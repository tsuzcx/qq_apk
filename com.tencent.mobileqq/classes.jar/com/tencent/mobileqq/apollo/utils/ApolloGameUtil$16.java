package com.tencent.mobileqq.apollo.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.utils.ShortcutUtils;

final class ApolloGameUtil$16
  implements Runnable
{
  ApolloGameUtil$16(Context paramContext, String paramString, ApolloGameUtil.ShortcutCreateResult paramShortcutCreateResult, Intent paramIntent, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (ShortcutUtils.a(this.jdField_a_of_type_AndroidContentContext, new String[] { this.jdField_a_of_type_JavaLangString }))
    {
      ApolloGameUtil.a(2);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$ShortcutCreateResult != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$ShortcutCreateResult.a(2);
      }
    }
    label130:
    do
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            ApolloGameUtil.a(this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap);
            Thread.sleep(1000L);
            if (!ShortcutUtils.a(this.jdField_a_of_type_AndroidContentContext, new String[] { this.jdField_a_of_type_JavaLangString })) {
              break label130;
            }
            ApolloGameUtil.a(0);
            if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$ShortcutCreateResult != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$ShortcutCreateResult.a(0);
              return;
            }
          }
          catch (Exception localException)
          {
            ApolloGameUtil.a(4);
          }
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$ShortcutCreateResult == null);
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$ShortcutCreateResult.a(4);
      return;
      ApolloGameUtil.a(3);
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$ShortcutCreateResult == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$ShortcutCreateResult.a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.16
 * JD-Core Version:    0.7.0.1
 */