package com.tencent.mobileqq.apollo.view;

import android.graphics.Bitmap;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;

public class SimpleFrameZipDecoder
  implements Handler.Callback
{
  protected int a;
  private long jdField_a_of_type_Long;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  protected SimpleFrameZipDecoder.IDownloadable a;
  protected SimpleFrameZipDecoder.OnFrameDecodeListener a;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  
  public SimpleFrameZipDecoder(SimpleFrameZipDecoder.IDownloadable paramIDownloadable, SimpleFrameZipDecoder.OnFrameDecodeListener paramOnFrameDecodeListener)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewSimpleFrameZipDecoder$IDownloadable = paramIDownloadable;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewSimpleFrameZipDecoder$OnFrameDecodeListener = paramOnFrameDecodeListener;
  }
  
  private void a(boolean paramBoolean, File paramFile, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      a(paramFile, paramString);
      this.jdField_a_of_type_ArrayOfJavaLangString = new File(paramString).list();
      this.jdField_a_of_type_Int = 3;
      if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
      {
        int i = 0;
        while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
        {
          paramFile = this.jdField_a_of_type_ArrayOfJavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
          paramFile[i] = localStringBuilder.toString();
          i += 1;
        }
      }
      if (this.jdField_a_of_type_Boolean)
      {
        b();
        if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
        {
          this.jdField_c_of_type_Int = 0;
          this.jdField_b_of_type_Boolean = true;
          new SimpleFrameZipDecoder.DecodeAsyncTask(this, 0).execute(new Integer[] { Integer.valueOf(this.jdField_c_of_type_Int) });
          return;
        }
      }
    }
    catch (OutOfMemoryError paramFile)
    {
      QLog.e("[cmshow]SimpleFrameZipDecoder", 2, paramFile.getMessage());
      this.jdField_a_of_type_Int = 2;
      return;
    }
    catch (Exception paramFile)
    {
      QLog.e("[cmshow]SimpleFrameZipDecoder", 2, paramFile.getMessage());
      this.jdField_a_of_type_Int = 2;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 3)
    {
      b();
      try
      {
        if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
        {
          this.jdField_c_of_type_Int = 0;
          this.jdField_b_of_type_Boolean = true;
          new SimpleFrameZipDecoder.DecodeAsyncTask(this, 0).execute(new Integer[] { Integer.valueOf(this.jdField_c_of_type_Int) });
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("[cmshow]SimpleFrameZipDecoder", 2, localException, new Object[0]);
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (!paramString2.equals(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_b_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_Int = 0;
      b();
      this.jdField_a_of_type_ArrayOfJavaLangString = null;
    }
    paramInt = this.jdField_a_of_type_Int;
    if ((paramInt == 2) || (paramInt == 0))
    {
      paramString2 = b(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = paramString2;
      Object localObject = new File(paramString2);
      ((File)localObject).mkdirs();
      localObject = ((File)localObject).list();
      File localFile = new File(this.jdField_b_of_type_JavaLangString);
      if ((localObject != null) && (localObject.length > 0))
      {
        a(false, localFile, paramString2);
        return;
      }
      if (localFile.exists())
      {
        a(true, localFile, paramString2);
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloViewSimpleFrameZipDecoder$IDownloadable;
      if (localObject != null)
      {
        ((SimpleFrameZipDecoder.IDownloadable)localObject).a(this, paramString1, this.jdField_b_of_type_JavaLangString, paramString2);
        return;
      }
      this.jdField_a_of_type_Int = 2;
    }
  }
  
  public void a(Bitmap paramBitmap, int paramInt)
  {
    if ((this.jdField_b_of_type_Boolean) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      long l1 = System.currentTimeMillis();
      long l2 = l1 - this.jdField_a_of_type_Long;
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      if (l2 > this.jdField_b_of_type_Int)
      {
        this.jdField_a_of_type_Long = l1;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(255, this.jdField_c_of_type_Int, 0).sendToTarget();
      }
      else
      {
        paramBitmap = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(255, this.jdField_c_of_type_Int, 0);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(paramBitmap, this.jdField_b_of_type_Int - l2);
      }
      this.jdField_c_of_type_Int = (paramInt + 1);
    }
  }
  
  protected void a(File paramFile, String paramString)
  {
    if ((paramFile.exists()) && (!TextUtils.isEmpty(paramString))) {
      ZipUtils.unZipFile(paramFile, paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadFinish，result:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" url:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" zipFile:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" folder:");
      localStringBuilder.append(paramString3);
      QLog.d("[cmshow]SimpleFrameZipDecoder", 2, localStringBuilder.toString());
    }
    paramString1 = this.jdField_b_of_type_JavaLangString;
    if ((paramString1 != null) && (!paramString1.equals(paramString2)))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("onDownloadFinish，zipFile unEqual mLocalZipPath:");
        paramString1.append(this.jdField_b_of_type_JavaLangString);
        QLog.d("[cmshow]SimpleFrameZipDecoder", 2, paramString1.toString());
      }
      return;
    }
    if (paramBoolean)
    {
      paramString1 = new File(paramString2);
      if (paramString1.exists())
      {
        a(true, paramString1, paramString3);
        return;
      }
      this.jdField_a_of_type_Int = 2;
      return;
    }
    this.jdField_a_of_type_Int = 2;
  }
  
  protected String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf(".zip");
      String str = paramString;
      if (i > 0) {
        str = paramString.substring(0, i);
      }
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(File.separator);
      return paramString.toString();
    }
    return "";
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 255) {
      return false;
    }
    if (!this.jdField_b_of_type_Boolean) {
      return true;
    }
    SimpleFrameZipDecoder.OnFrameDecodeListener localOnFrameDecodeListener = this.jdField_a_of_type_ComTencentMobileqqApolloViewSimpleFrameZipDecoder$OnFrameDecodeListener;
    if (localOnFrameDecodeListener == null) {
      return false;
    }
    localOnFrameDecodeListener.a(paramMessage.arg1, this.jdField_a_of_type_AndroidGraphicsBitmap);
    if (this.jdField_c_of_type_Boolean)
    {
      paramMessage = this.jdField_a_of_type_ArrayOfJavaLangString;
      if ((paramMessage != null) && (this.jdField_c_of_type_Int >= paramMessage.length) && (paramMessage.length != 1)) {
        this.jdField_c_of_type_Int = 0;
      }
    }
    paramMessage = this.jdField_a_of_type_ArrayOfJavaLangString;
    if (paramMessage != null)
    {
      int i = paramMessage.length;
      int j = this.jdField_c_of_type_Int;
      if (i > j)
      {
        new SimpleFrameZipDecoder.DecodeAsyncTask(this, j).execute(new Integer[] { Integer.valueOf(this.jdField_c_of_type_Int) });
        break label151;
      }
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewSimpleFrameZipDecoder$OnFrameDecodeListener.a();
    label151:
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.SimpleFrameZipDecoder
 * JD-Core Version:    0.7.0.1
 */