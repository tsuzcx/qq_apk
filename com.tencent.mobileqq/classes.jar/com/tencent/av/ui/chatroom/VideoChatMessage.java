package com.tencent.av.ui.chatroom;

import com.tencent.av.chatroom.ChatRoomUtil;
import com.tencent.mobileqq.text.QQText;
import java.util.List;

public class VideoChatMessage
{
  public static final Object a;
  private static VideoChatMessage jdField_b_of_type_ComTencentAvUiChatroomVideoChatMessage = null;
  private static int jdField_c_of_type_Int = 0;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private VideoChatMessage jdField_a_of_type_ComTencentAvUiChatroomVideoChatMessage = null;
  private QQText jdField_a_of_type_ComTencentMobileqqTextQQText;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static VideoChatMessage a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_ComTencentAvUiChatroomVideoChatMessage != null)
      {
        VideoChatMessage localVideoChatMessage = jdField_b_of_type_ComTencentAvUiChatroomVideoChatMessage;
        jdField_b_of_type_ComTencentAvUiChatroomVideoChatMessage = localVideoChatMessage.jdField_a_of_type_ComTencentAvUiChatroomVideoChatMessage;
        localVideoChatMessage.jdField_a_of_type_ComTencentAvUiChatroomVideoChatMessage = null;
        jdField_c_of_type_Int -= 1;
        return localVideoChatMessage;
      }
      return new VideoChatMessage();
    }
  }
  
  public static void a(List<VideoChatMessage> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        VideoChatMessage localVideoChatMessage = (VideoChatMessage)paramList.remove(i);
        if (localVideoChatMessage != null) {
          localVideoChatMessage.a();
        }
        i -= 1;
      }
    }
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTextQQText;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTextQQText = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = null;
    this.d = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = null;
    this.e = null;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_c_of_type_Int < 200)
      {
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatMessage = jdField_b_of_type_ComTencentAvUiChatroomVideoChatMessage;
        jdField_b_of_type_ComTencentAvUiChatroomVideoChatMessage = this;
        jdField_c_of_type_Int += 1;
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTextQQText = ChatRoomUtil.a(paramString, 16);
  }
  
  public String b()
  {
    return this.e;
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void c(String paramString)
  {
    this.e = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoChatMessage{type=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", content='");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTextQQText);
    localStringBuilder.append('\'');
    localStringBuilder.append(", filepath='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sendState=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", time='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", header='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", imageUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", voiceTime=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", msgId='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatMessage
 * JD-Core Version:    0.7.0.1
 */