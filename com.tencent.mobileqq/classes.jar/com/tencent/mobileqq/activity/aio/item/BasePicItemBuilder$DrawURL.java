package com.tencent.mobileqq.activity.aio.item;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class BasePicItemBuilder$DrawURL
{
  public URL a;
  public boolean a;
  public boolean b;
  
  public BasePicItemBuilder$DrawURL(MessageForPic paramMessageForPic)
  {
    paramMessageForPic.checkType();
    Object localObject;
    if (((paramMessageForPic.imageType == 3) || (paramMessageForPic.imageType == 2000)) && (BasePicItemBuilder.h))
    {
      this.jdField_a_of_type_Boolean = true;
      localObject = URLDrawableHelper.getURL(paramMessageForPic, 1, null);
      if (AbsDownloader.getFile(((URL)localObject).toString()) != null)
      {
        this.jdField_a_of_type_JavaNetURL = ((URL)localObject);
        this.b = true;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getThumbDrawable,using GIF_BIG,uniseq:");
          ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
          ((StringBuilder)localObject).append(" url:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaNetURL);
          QLog.d("PicItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    if (this.jdField_a_of_type_JavaNetURL == null)
    {
      this.jdField_a_of_type_JavaNetURL = URLDrawableHelper.getURL(paramMessageForPic, 65537, null);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getThumbDrawable,using thumb,uniseq:");
        ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
        ((StringBuilder)localObject).append(" url:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaNetURL);
        QLog.d("PicItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  @NonNull
  public String toString()
  {
    URL localURL = this.jdField_a_of_type_JavaNetURL;
    if (localURL != null) {
      return localURL.toString();
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.BasePicItemBuilder.DrawURL
 * JD-Core Version:    0.7.0.1
 */