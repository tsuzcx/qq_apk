package com.tencent.mobileqq.apollo.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import anpg;
import bhsk;

final class ApolloGameUtil$17
  implements Runnable
{
  ApolloGameUtil$17(Context paramContext, String paramString, anpg paramanpg, Intent paramIntent, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (bhsk.a(this.jdField_a_of_type_AndroidContentContext, new String[] { this.jdField_a_of_type_JavaLangString }))
    {
      ApolloGameUtil.a(2);
      if (this.jdField_a_of_type_Anpg != null) {
        this.jdField_a_of_type_Anpg.a(2);
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
            if (!bhsk.a(this.jdField_a_of_type_AndroidContentContext, new String[] { this.jdField_a_of_type_JavaLangString })) {
              break label130;
            }
            ApolloGameUtil.a(0);
            if (this.jdField_a_of_type_Anpg != null)
            {
              this.jdField_a_of_type_Anpg.a(0);
              return;
            }
          }
          catch (Exception localException)
          {
            ApolloGameUtil.a(4);
          }
        }
      } while (this.jdField_a_of_type_Anpg == null);
      this.jdField_a_of_type_Anpg.a(4);
      return;
      ApolloGameUtil.a(3);
    } while (this.jdField_a_of_type_Anpg == null);
    this.jdField_a_of_type_Anpg.a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.17
 * JD-Core Version:    0.7.0.1
 */