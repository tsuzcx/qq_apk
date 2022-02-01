package com.tencent.av;

import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SessionMgr
{
  static volatile SessionMgr jdField_a_of_type_ComTencentAvSessionMgr;
  public static String a = "AvSessionMgr";
  private SessionInfo jdField_a_of_type_ComTencentAvAppSessionInfo = new SessionInfo();
  private Map<String, SessionInfo> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static int a(int paramInt)
  {
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt != 1011)
        {
          if (paramInt != 3000) {
            return 3;
          }
          return 2;
        }
      }
      else {
        return 1;
      }
    }
    return 3;
  }
  
  public static SessionMgr a()
  {
    if (jdField_a_of_type_ComTencentAvSessionMgr == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvSessionMgr == null) {
          jdField_a_of_type_ComTencentAvSessionMgr = new SessionMgr();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvSessionMgr;
  }
  
  public static String a(int paramInt, String paramString, int... paramVarArgs)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.startsWith("+")) {
        str = paramString.substring(1);
      }
    }
    paramString = new StringBuilder();
    paramString.append(String.valueOf(paramInt));
    paramString.append("-");
    paramString.append(str);
    str = paramString.toString();
    paramString = str;
    if (paramInt == 1)
    {
      paramString = str;
      if (paramVarArgs != null)
      {
        paramString = str;
        if (paramVarArgs.length == 1)
        {
          paramString = new StringBuilder();
          paramString.append(str);
          paramString.append("-");
          paramString.append(paramVarArgs[0]);
          paramString = paramString.toString();
        }
      }
    }
    return paramString;
  }
  
  public static boolean a(SessionInfo paramSessionInfo)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramSessionInfo == null) {
      return false;
    }
    if (paramSessionInfo.k != -1)
    {
      bool1 = bool2;
      if (paramSessionInfo.k != 3000)
      {
        bool1 = bool2;
        if (paramSessionInfo.k != 1) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (paramSessionInfo.E != 0)
    {
      if ((paramSessionInfo.E == 3) || (paramSessionInfo.E == 100) || (paramSessionInfo.E == 4)) {
        bool1 = true;
      }
      return bool1;
    }
    if (paramSessionInfo.y) {
      return true;
    }
    if (paramSessionInfo.K) {}
    return false;
  }
  
  public int a()
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
        i = 0;
        if (!localIterator.hasNext()) {
          continue;
        }
        String str1 = (String)localIterator.next();
        localSessionInfo = (SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(str1);
        j = i;
        if (!localSessionInfo.e()) {
          j = i + 1;
        }
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        str2 = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getAliveSessionCount, count[");
        localStringBuilder.append(j);
        localStringBuilder.append("], key[");
        localStringBuilder.append(str1);
        localStringBuilder.append("], main[");
        if (localSessionInfo != this.jdField_a_of_type_ComTencentAvAppSessionInfo) {
          continue;
        }
        bool = true;
      }
      finally
      {
        int i;
        SessionInfo localSessionInfo;
        int j;
        String str2;
        StringBuilder localStringBuilder;
        continue;
        throw localObject;
        continue;
        boolean bool = false;
        continue;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("], session[");
      localStringBuilder.append(localSessionInfo);
      localStringBuilder.append("]");
      QLog.w(str2, 1, localStringBuilder.toString());
      i = j;
    }
    return i;
  }
  
  public SessionInfo a()
  {
    try
    {
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
      return localSessionInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public SessionInfo a(String paramString)
  {
    Object localObject1 = null;
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        localObject2 = (SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        if ((localObject2 != null) && (((SessionInfo)localObject2).jdField_c_of_type_JavaLangString != null) && (((SessionInfo)localObject2).jdField_c_of_type_JavaLangString.equals(paramString))) {
          if (localObject1 != null)
          {
            boolean bool = a((SessionInfo)localObject2);
            if (!bool) {}
          }
          else
          {
            localObject1 = localObject2;
          }
        }
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public SessionInfo a(String paramString, boolean paramBoolean)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "createSession with null sessionId ");
        }
        return null;
      }
      Object localObject1;
      if (this.jdField_a_of_type_JavaUtilMap.get(paramString) != null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("createSession already exist sessionId : ");
          ((StringBuilder)localObject2).append(paramString);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        paramString = (SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        return paramString;
      }
      if (this.jdField_a_of_type_JavaUtilMap.isEmpty()) {
        localObject1 = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
      } else {
        localObject1 = new SessionInfo();
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject1);
      ((SessionInfo)localObject1).a("createSession", paramString);
      Object localObject2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createSession, sessionId[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], TAG[");
      localStringBuilder.append(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString);
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 1, localStringBuilder.toString());
      if ((this.jdField_a_of_type_JavaUtilMap.size() != 1) && (!paramBoolean)) {
        a(paramString, 1);
      } else {
        a(paramString, 2);
      }
      return localObject1;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt)
  {
    int k = -1;
    int m = 0;
    int j = k;
    int i = m;
    try
    {
      Object localObject;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        localObject = (SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        if (localObject == null)
        {
          i = 1;
          j = k;
        }
        else
        {
          k = ((SessionInfo)localObject).jdField_c_of_type_Int;
          if (((SessionInfo)localObject).jdField_c_of_type_Int != paramInt)
          {
            if (paramInt == 2) {
              this.jdField_a_of_type_ComTencentAvAppSessionInfo = ((SessionInfo)localObject);
            }
            ((SessionInfo)localObject).a(paramInt);
            j = k;
            i = m;
          }
          else
          {
            j = k;
            i = m;
            if (paramInt == 2)
            {
              j = k;
              i = m;
              if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != localObject)
              {
                this.jdField_a_of_type_ComTencentAvAppSessionInfo = ((SessionInfo)localObject);
                i = 2;
                j = k;
              }
            }
          }
        }
      }
      if ((QLog.isColorLevel()) || (j != paramInt) || (i != 0))
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setSessionStatus, sessionId[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], status[");
        if (i == 0)
        {
          paramString = new StringBuilder();
          paramString.append(j);
          paramString.append("->");
          paramString.append(paramInt);
        }
        for (;;)
        {
          paramString = paramString.toString();
          break;
          paramString = new StringBuilder();
          paramString.append(paramInt);
          paramString.append("], step[");
          paramString.append(i);
        }
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public boolean a()
  {
    try
    {
      int i = a();
      boolean bool = true;
      if (i <= 1) {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(long paramLong, String paramString)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
      Object localObject1 = jdField_a_of_type_JavaLangString;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("removeSession, sessionId[");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("], size[");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilMap.size());
      ((StringBuilder)localObject2).append("], contains[");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      if (bool)
      {
        localObject1 = (SessionInfo)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        if (this.jdField_a_of_type_JavaUtilMap.size() == 1)
        {
          localObject2 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
          while (((Iterator)localObject2).hasNext()) {
            b((String)((Iterator)localObject2).next());
          }
        }
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == localObject1)
        {
          this.jdField_a_of_type_ComTencentAvAppSessionInfo = new SessionInfo();
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("removeSession, active is cur need remove one. id[");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append("]");
          QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        }
        return true;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public boolean a(String paramString)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  @Deprecated
  public boolean a(String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("changeSessionId   ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" to ");
        localStringBuilder.append(paramString2);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "changeSessionId not exist");
        }
        return false;
      }
      Object localObject = (SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
      ((SessionInfo)localObject).a("changeSessionId", paramString2);
      this.jdField_a_of_type_JavaUtilMap.remove(paramString1);
      this.jdField_a_of_type_JavaUtilMap.put(paramString2, localObject);
      return true;
    }
    finally {}
  }
  
  public SessionInfo b(String paramString)
  {
    Object localObject1 = null;
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        localObject2 = (SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        if ((localObject2 != null) && (TextUtils.equals(paramString, ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString))) {
          if ((localObject1 != null) || (((SessionInfo)localObject2).y))
          {
            if (a((SessionInfo)localObject2))
            {
              boolean bool = ((SessionInfo)localObject2).y;
              if (bool) {}
            }
          }
          else {
            localObject1 = localObject2;
          }
        }
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public boolean b()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        boolean bool = ((SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(str)).e();
        if (!bool) {
          return false;
        }
      }
      return true;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean b(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setMainSession sessionId[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.i(str, 2, localStringBuilder.toString(), new Throwable("setMainSession"));
      }
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        a(paramString, 2);
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public SessionInfo c(String paramString)
  {
    try
    {
      if ((!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (QLog.isColorLevel()))
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSession not exist sessionId : ");
        localStringBuilder.append(paramString);
        QLog.e(str, 2, localStringBuilder.toString());
      }
      paramString = (SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.SessionMgr
 * JD-Core Version:    0.7.0.1
 */