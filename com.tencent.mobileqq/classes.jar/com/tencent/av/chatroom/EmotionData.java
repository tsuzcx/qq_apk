package com.tencent.av.chatroom;

import com.tencent.mobileqq.text.style.EmoticonSpan;
import java.util.Comparator;
import java.util.List;

public class EmotionData
{
  public static final Object a;
  public static final Comparator<EmotionData> a;
  private static EmotionData b;
  private static int c;
  public int a;
  private EmotionData a;
  public EmoticonSpan a;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_ComTencentAvChatroomEmotionData = null;
    c = 0;
    jdField_a_of_type_JavaUtilComparator = new EmotionData.1();
  }
  
  private EmotionData(EmoticonSpan paramEmoticonSpan, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqTextStyleEmoticonSpan = paramEmoticonSpan;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static EmotionData a(EmoticonSpan paramEmoticonSpan, int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_ComTencentAvChatroomEmotionData != null)
      {
        EmotionData localEmotionData = jdField_b_of_type_ComTencentAvChatroomEmotionData;
        jdField_b_of_type_ComTencentAvChatroomEmotionData = localEmotionData.jdField_a_of_type_ComTencentAvChatroomEmotionData;
        localEmotionData.a(paramEmoticonSpan, paramInt1, paramInt2);
        c -= 1;
        return localEmotionData;
      }
      return new EmotionData(paramEmoticonSpan, paramInt1, paramInt2);
    }
  }
  
  private void a(EmoticonSpan paramEmoticonSpan, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentAvChatroomEmotionData = null;
    this.jdField_a_of_type_ComTencentMobileqqTextStyleEmoticonSpan = paramEmoticonSpan;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static void a(List<EmotionData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        EmotionData localEmotionData = (EmotionData)paramList.remove(i);
        if (localEmotionData != null) {
          localEmotionData.a();
        }
        i -= 1;
      }
    }
  }
  
  public void a()
  {
    a(null, -1, -1);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (c < 50)
      {
        this.jdField_a_of_type_ComTencentAvChatroomEmotionData = jdField_b_of_type_ComTencentAvChatroomEmotionData;
        jdField_b_of_type_ComTencentAvChatroomEmotionData = this;
        c += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.chatroom.EmotionData
 * JD-Core Version:    0.7.0.1
 */