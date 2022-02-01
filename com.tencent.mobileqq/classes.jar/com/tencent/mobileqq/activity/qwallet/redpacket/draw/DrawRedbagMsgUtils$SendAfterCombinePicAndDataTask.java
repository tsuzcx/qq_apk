package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.scribble.ScribbleUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

class DrawRedbagMsgUtils$SendAfterCombinePicAndDataTask
  extends AsyncTask<Void, Void, Integer>
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private DrawRedbagMsgUtils.CombineCallback jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawRedbagMsgUtils$CombineCallback;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  
  int a()
  {
    String str1 = DrawRedbagMsgUtils.jdField_a_of_type_JavaLangString + "temp/" + System.currentTimeMillis();
    String str2 = DrawRedbagMsgUtils.jdField_a_of_type_JavaLangString + "temp/" + System.currentTimeMillis() + "_data";
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawRedbagMsgUtils$CombineCallback != null) {
      bool = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawRedbagMsgUtils$CombineCallback.a(str2);
    }
    if (!bool) {
      return DrawRedbagMsgUtils.d;
    }
    if (!FileUtil.a(str2)) {
      return DrawRedbagMsgUtils.e;
    }
    Object localObject = a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_c_of_type_Int = localObject.length;
    if (!ScribbleUtils.a((byte[])localObject, str2, str1)) {
      return DrawRedbagMsgUtils.jdField_b_of_type_Int;
    }
    localObject = ScribbleUtils.a(str1);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return DrawRedbagMsgUtils.jdField_c_of_type_Int;
    }
    this.jdField_b_of_type_JavaLangString = ((String)localObject);
    this.jdField_c_of_type_JavaLangString = DrawRedbagMsgUtils.a(this.jdField_b_of_type_JavaLangString);
    this.d = DrawRedbagMsgUtils.b(this.jdField_b_of_type_JavaLangString);
    if (!ScribbleUtils.a(str1, this.jdField_c_of_type_JavaLangString).booleanValue()) {
      return DrawRedbagMsgUtils.jdField_b_of_type_Int;
    }
    if (!ScribbleUtils.a(str2, this.d).booleanValue()) {
      return DrawRedbagMsgUtils.jdField_b_of_type_Int;
    }
    FileUtil.c(str1);
    FileUtil.c(str2);
    return DrawRedbagMsgUtils.jdField_a_of_type_Int;
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(a());
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    QLog.i(this.e, 2, "doBeforeSendScribble result = " + paramInteger);
    if (paramInteger.intValue() == DrawRedbagMsgUtils.jdField_a_of_type_Int)
    {
      ScribbleBaseOperator localScribbleBaseOperator = new ScribbleBaseOperator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      MessageForScribble localMessageForScribble = localScribbleBaseOperator.a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      localMessageForScribble.mExistInfo.mCombineFileExist = true;
      localMessageForScribble.mExistInfo.mDataFileExist = true;
      localMessageForScribble.mExistInfo.mLocalPathExist = true;
      localMessageForScribble.mExistInfo.mInit = true;
      localScribbleBaseOperator.a(localMessageForScribble);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawRedbagMsgUtils$CombineCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawRedbagMsgUtils$CombineCallback.a(paramInteger.intValue());
    }
  }
  
  public byte[] a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedbagMsgUtils.SendAfterCombinePicAndDataTask
 * JD-Core Version:    0.7.0.1
 */