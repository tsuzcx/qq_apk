package com.tencent.mobileqq.activity.miniaio;

import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MiniChatMsgProxy
{
  private static final MiniChatMsgProxy jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatMsgProxy = new MiniChatMsgProxy();
  private Map<String, List<WeakReference<IChatWindow>>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private int a(List<WeakReference<IChatWindow>> paramList, IChatWindow paramIChatWindow)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        IChatWindow localIChatWindow = (IChatWindow)((WeakReference)paramList.next()).get();
        if ((localIChatWindow != null) && (localIChatWindow == paramIChatWindow)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static MiniChatMsgProxy a()
  {
    return jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatMsgProxy;
  }
  
  public void a(int paramInt, String paramString, IChatWindow paramIChatWindow)
  {
    try
    {
      String str = UinTypeUtil.a(paramString, paramInt);
      List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(str);
      paramString = localList;
      if (localList == null)
      {
        paramString = new ArrayList(2);
        this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
      }
      if (a(paramString, paramIChatWindow) < 0) {
        paramString.add(new WeakReference(paramIChatWindow));
      }
      return;
    }
    finally {}
  }
  
  public boolean a(int paramInt, String paramString)
  {
    boolean bool2 = false;
    try
    {
      paramString = UinTypeUtil.a(paramString, paramInt);
      paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      boolean bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.size() > 0)
        {
          paramString = paramString.iterator();
          do
          {
            bool1 = bool2;
            if (!paramString.hasNext()) {
              break;
            }
          } while ((IChatWindow)((WeakReference)paramString.next()).get() == null);
          bool1 = true;
        }
      }
      if (QLog.isColorLevel())
      {
        paramString = MiniPieHelper.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hasOtherInstance -->");
        localStringBuilder.append(bool1);
        QLog.d(paramString, 2, localStringBuilder.toString());
      }
      return bool1;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void b(int paramInt, String paramString, IChatWindow paramIChatWindow)
  {
    try
    {
      paramString = UinTypeUtil.a(paramString, paramInt);
      paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if ((paramString != null) && (paramString.size() > 0) && (paramIChatWindow != null))
      {
        paramInt = a(paramString, paramIChatWindow);
        if (paramInt >= 0) {
          paramString.remove(paramInt);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniChatMsgProxy
 * JD-Core Version:    0.7.0.1
 */