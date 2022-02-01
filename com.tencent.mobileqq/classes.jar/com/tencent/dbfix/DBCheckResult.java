package com.tencent.dbfix;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBCheckResult
{
  private static final String DB_STATUS_OK = "ok";
  private static final String INDEX_CORRUPT_DESCRIPTION_AUTO_INDEX_PREFIX = "sqlite_autoindex_";
  private static final String INDEX_CORRUPT_DESCRIPTION_AUTO_INDEX_SUFFIX = "_1";
  private static final String INDEX_CORRUPT_DESCRIPTION_IDX_SUFFIX = "_idx";
  private static final String INDEX_CORRUPT_DESCRIPTION_MISSING = "missing from index";
  private static final String INDEX_CORRUPT_DESCRIPTION_ROW = "row";
  private static final String INDEX_CORRUPT_DESCRIPTION_WRONG_PREFIX = "wrong # of entries in index";
  private static final String PAGE_CORRUPT_NORMAL = "On page";
  private static final String PAGE_CORRUPT_START = "*** in database main ***";
  private static final String PAGE_CORRUPT_TREE = "On tree page";
  private static final int REASON_CODE_EMPTY = 9999;
  public static final int REASON_CODE_INDEX = 1000;
  public static final int REASON_CODE_NONE = -1000;
  public static final int REASON_CODE_OK = 0;
  public static final int REASON_CODE_OTHER = 1002;
  public static final int REASON_CODE_PAGE_TREE_CORRUPT = 1001;
  private static final String TAG = "DBIntegrityCheckManager";
  public long checkCompleteTime = 0L;
  public long checkStartTime = 0L;
  private final List<DBCheckResultItem> result = new ArrayList();
  
  private boolean isPageTreeCorrupt(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (!paramString.startsWith("*** in database main ***")) {
      return false;
    }
    if ((paramString.contains("On page")) || (paramString.contains("On tree page"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean isReasonIndexCorrupt(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if (paramString.startsWith("wrong # of entries in index")) {
      return true;
    }
    bool1 = bool2;
    if (paramString.contains("missing from index"))
    {
      bool1 = bool2;
      if (paramString.contains("row")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean isStatusOK(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return TextUtils.equals("ok", paramString);
  }
  
  private int parseSQLExecuteFailCode(String paramString)
  {
    paramString = paramString.trim();
    if (isReasonIndexCorrupt(paramString)) {
      return 1000;
    }
    if (isPageTreeCorrupt(paramString)) {
      return 1001;
    }
    if (isStatusOK(paramString)) {
      return 0;
    }
    return 1002;
  }
  
  public String buildDescription()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = this.result.size();
    int i = 0;
    while (i < j)
    {
      String str = ((DBCheckResultItem)this.result.get(i)).description;
      localStringBuilder.append(str);
      if (!str.endsWith(";")) {
        localStringBuilder.append(";");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void clear()
  {
    this.checkStartTime = 0L;
    this.checkCompleteTime = 0L;
    this.result.clear();
  }
  
  public List<DBCheckResultItem> getCheckResult()
  {
    return this.result;
  }
  
  public int getCorruptReasonCode()
  {
    if (this.result.isEmpty()) {
      return 9999;
    }
    int i = 0;
    int m = this.result.size();
    int k;
    for (int j = 1002; i < m; j = k)
    {
      DBCheckResultItem localDBCheckResultItem = (DBCheckResultItem)this.result.get(i);
      k = localDBCheckResultItem.errCode;
      if (k != -1000) {
        return k;
      }
      k = j;
      if (j == 1002) {
        k = parseSQLExecuteFailCode(localDBCheckResultItem.description);
      }
      i += 1;
    }
    return j;
  }
  
  public List<String> getIndexErrTable()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.result.iterator();
    while (localIterator.hasNext())
    {
      String str = ((DBCheckResultItem)localIterator.next()).description;
      if ((!TextUtils.isEmpty(str)) && (str.startsWith("wrong # of entries in index")))
      {
        str = str.substring(28);
        int i = str.length();
        if (str.endsWith("_idx")) {
          str = str.substring(0, i - 4);
        } else if (str.startsWith("sqlite_autoindex_")) {
          str = str.substring(17, i - 2);
        } else {
          str = "";
        }
        if (!localArrayList.contains(str))
        {
          DBFixLog.d("DBIntegrityCheckManager", new Object[] { "tableName: ", str });
          localArrayList.add(str);
        }
      }
    }
    return localArrayList;
  }
  
  public void setResult(List<DBCheckResultItem> paramList)
  {
    this.result.clear();
    this.result.addAll(paramList);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DBIntegrityCheckResult{result=");
    localStringBuilder.append(this.result);
    localStringBuilder.append(", checkStartTime=");
    localStringBuilder.append(this.checkStartTime);
    localStringBuilder.append(", checkCompleteTime=");
    localStringBuilder.append(this.checkCompleteTime);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.dbfix.DBCheckResult
 * JD-Core Version:    0.7.0.1
 */