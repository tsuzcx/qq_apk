package com.tencent.aelight.camera.aioeditor.capture.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class QIMRedDotConfig
  implements Serializable
{
  public static final String CACHE_RED_DOT_NAME = "qim_red_dot_config.cfg";
  public static final String COMB0_ICON_VERSION_ID = "combo_iconRedDotVersion";
  public static final String COMBO_DEFAULT_CATEGORY_ID = "combo_defaultCategoryId";
  public static final String COMBO_DEFAULT_CATEGORY_VERSION = "combo_defaultCategoryVersion";
  public static final String COMBO_SHOW_RED_DOT = "combo_needRedDot";
  public static final String DEFAULT_CATEGORY_ID = "defaultCategoryId";
  public static final String DEFAULT_CATEGORY_VERSION = "defaultCategoryVersion";
  public static final String DEFAULT_USE_ID = "defaultUseId";
  public static final String DEFAULT_USE_VERSION = "defaultUseVersion";
  public static final int DOT_TYPE_COMBO_CATEGORY = 7;
  public static final int DOT_TYPE_DEFAULT_USE = 4;
  public static final int DOT_TYPE_FILTER_CATEGORY = 5;
  public static final int DOT_TYPE_ITEM_ICON = 3;
  public static final int DOT_TYPE_SECOND_ICON = 2;
  public static final int DOT_TYPE_TOP_ICON = 1;
  public static final int DOT_TYPE_TOP_ICON_COMBO = 6;
  public static final String ICON_VERSION_ID = "iconRedDotVersion";
  public static final int ILLEGAL_INDEX = -1;
  public static final String RED_DOT_LIST = "itemNeedRedDot";
  public static final String RED_DOT_LIST_VERSION = "itemRedDotVersion";
  public static final String SHOW_RED_DOT = "needRedDot";
  public static final int SHOW_TIME = 86400000;
  public static final String TAG = "QIMRedDotConfig";
  public static final int TYPE_FILTER_REDDOT = 1;
  public static final int TYPE_PTV_TEMPLATE_REDDOT = 2;
  public static final String VERSION_ID = "redDotVersion";
  private static final long serialVersionUID = 1L;
  public HashMap<Integer, QIMRedDotConfig.CategoryRedConfig> categories = new HashMap();
  public int comboDefaultCategoryId;
  public int comboDefaultCategoryVer;
  public long comboFirstShowTime;
  public boolean comboHasChoose;
  public boolean comboHasShow;
  public int comboIconVersion;
  public boolean comboShowRedDot;
  public int defaultCategoryId;
  public int defaultCategoryVer;
  public String defaultUseId;
  public int defaultUseVer;
  public long firstShowTime;
  public boolean hasChoose;
  public boolean hasShow;
  public boolean hasUse;
  public int iconVersion;
  public transient boolean isComboShowing = false;
  public transient boolean isShowing = false;
  public HashMap<String, QIMRedDotConfig.RedDotItemConfig> redDotItems = new HashMap();
  public int redDotVersion;
  public boolean showRedDot;
  public int type;
  public transient boolean update = false;
  
  public QIMRedDotConfig(int paramInt)
  {
    this.type = paramInt;
  }
  
  /* Error */
  public static QIMRedDotConfig getRedDotConfigFromFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 137	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: ldc 10
    //   16: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: astore_3
    //   20: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +53 -> 76
    //   26: new 148	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   33: astore_0
    //   34: aload_0
    //   35: ldc 151
    //   37: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_0
    //   42: aload_3
    //   43: invokevirtual 159	java/io/File:getPath	()Ljava/lang/String;
    //   46: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_0
    //   51: ldc 161
    //   53: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_0
    //   58: aload_3
    //   59: invokevirtual 164	java/io/File:exists	()Z
    //   62: invokevirtual 167	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: ldc 68
    //   68: iconst_2
    //   69: aload_0
    //   70: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_3
    //   77: invokevirtual 164	java/io/File:exists	()Z
    //   80: ifne +5 -> 85
    //   83: aconst_null
    //   84: areturn
    //   85: new 176	java/io/ObjectInputStream
    //   88: dup
    //   89: new 178	java/io/BufferedInputStream
    //   92: dup
    //   93: new 180	java/io/FileInputStream
    //   96: dup
    //   97: aload_3
    //   98: invokespecial 183	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   101: invokespecial 186	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   104: invokespecial 187	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: astore_1
    //   108: aload_1
    //   109: astore_0
    //   110: aload_1
    //   111: invokevirtual 191	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   114: checkcast 2	com/tencent/aelight/camera/aioeditor/capture/data/QIMRedDotConfig
    //   117: astore_2
    //   118: aload_1
    //   119: astore_0
    //   120: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +46 -> 169
    //   126: aload_1
    //   127: astore_0
    //   128: new 148	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   135: astore 4
    //   137: aload_1
    //   138: astore_0
    //   139: aload 4
    //   141: ldc 193
    //   143: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_1
    //   148: astore_0
    //   149: aload 4
    //   151: aload_2
    //   152: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_1
    //   157: astore_0
    //   158: ldc 68
    //   160: iconst_2
    //   161: aload 4
    //   163: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: aload_1
    //   170: invokevirtual 199	java/io/ObjectInputStream:close	()V
    //   173: aload_2
    //   174: areturn
    //   175: astore_2
    //   176: goto +12 -> 188
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_1
    //   182: goto +39 -> 221
    //   185: astore_2
    //   186: aconst_null
    //   187: astore_1
    //   188: aload_1
    //   189: astore_0
    //   190: aload_3
    //   191: invokevirtual 202	java/io/File:delete	()Z
    //   194: pop
    //   195: aload_1
    //   196: astore_0
    //   197: ldc 68
    //   199: iconst_1
    //   200: ldc 204
    //   202: aload_2
    //   203: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   206: aload_1
    //   207: ifnull +7 -> 214
    //   210: aload_1
    //   211: invokevirtual 199	java/io/ObjectInputStream:close	()V
    //   214: aconst_null
    //   215: areturn
    //   216: astore_2
    //   217: aload_0
    //   218: astore_1
    //   219: aload_2
    //   220: astore_0
    //   221: aload_1
    //   222: ifnull +7 -> 229
    //   225: aload_1
    //   226: invokevirtual 199	java/io/ObjectInputStream:close	()V
    //   229: aload_0
    //   230: athrow
    //   231: astore_0
    //   232: goto -59 -> 173
    //   235: astore_0
    //   236: aconst_null
    //   237: areturn
    //   238: astore_1
    //   239: goto -10 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	paramString	String
    //   107	119	1	localObject1	Object
    //   238	1	1	localIOException	java.io.IOException
    //   117	57	2	localQIMRedDotConfig	QIMRedDotConfig
    //   175	1	2	localException1	java.lang.Exception
    //   185	18	2	localException2	java.lang.Exception
    //   216	4	2	localObject2	Object
    //   19	172	3	localFile	java.io.File
    //   135	27	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   110	118	175	java/lang/Exception
    //   120	126	175	java/lang/Exception
    //   128	137	175	java/lang/Exception
    //   139	147	175	java/lang/Exception
    //   149	156	175	java/lang/Exception
    //   158	169	175	java/lang/Exception
    //   85	108	179	finally
    //   85	108	185	java/lang/Exception
    //   110	118	216	finally
    //   120	126	216	finally
    //   128	137	216	finally
    //   139	147	216	finally
    //   149	156	216	finally
    //   158	169	216	finally
    //   190	195	216	finally
    //   197	206	216	finally
    //   169	173	231	java/io/IOException
    //   210	214	235	java/io/IOException
    //   225	229	238	java/io/IOException
  }
  
  public static void saveRedDotConfig(QIMRedDotConfig paramQIMRedDotConfig, String paramString)
  {
    if (paramQIMRedDotConfig != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveRedDotConfig|config= ");
        localStringBuilder.append(paramQIMRedDotConfig);
        QLog.d("QIMRedDotConfig", 2, localStringBuilder.toString());
      }
      ThreadManager.getFileThreadHandler().post(new QIMRedDotConfig.1(paramString, paramQIMRedDotConfig));
    }
  }
  
  public boolean needShowRedDot(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 6) {
            return false;
          }
          return showComboIconRedDot();
        }
        return showRedDot(paramInt2, paramString);
      }
      return showCategoryRedDot(paramInt2);
    }
    return showIconRedDot();
  }
  
  public boolean showCategoryRedDot(int paramInt)
  {
    if (this.categories.size() > 0)
    {
      QIMRedDotConfig.CategoryRedConfig localCategoryRedConfig = (QIMRedDotConfig.CategoryRedConfig)this.categories.get(Integer.valueOf(paramInt));
      if ((localCategoryRedConfig != null) && (localCategoryRedConfig.showRedDot))
      {
        StringBuilder localStringBuilder;
        if (!localCategoryRedConfig.hasShow)
        {
          if (localCategoryRedConfig.firstShowTime > 0L)
          {
            if (System.currentTimeMillis() - localCategoryRedConfig.firstShowTime < 86400000L)
            {
              localCategoryRedConfig.isShowing = true;
              return true;
            }
            this.update = true;
            localCategoryRedConfig.hasShow = true;
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("showCategoryRedDot out of time | id=");
              localStringBuilder.append(localCategoryRedConfig.categoryId);
              QLog.d("QIMRedDotConfig", 2, localStringBuilder.toString());
            }
          }
          else
          {
            this.update = true;
            localCategoryRedConfig.firstShowTime = System.currentTimeMillis();
            localCategoryRedConfig.isShowing = true;
            return true;
          }
        }
        else if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("showCategoryRedDot hasShow | id=");
          localStringBuilder.append(localCategoryRedConfig.categoryId);
          QLog.d("QIMRedDotConfig", 2, localStringBuilder.toString());
        }
      }
    }
    return false;
  }
  
  public boolean showComboIconRedDot()
  {
    if (!this.comboShowRedDot) {
      return false;
    }
    StringBuilder localStringBuilder;
    if (this.comboHasShow)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("showIconRedDot hasShow | type=");
        localStringBuilder.append(this.type);
        QLog.d("QIMRedDotConfig", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (this.comboFirstShowTime > 0L)
    {
      if (System.currentTimeMillis() - this.comboFirstShowTime >= 86400000L)
      {
        this.comboHasShow = true;
        this.update = true;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("showIconRedDot out of time | type=");
          localStringBuilder.append(this.type);
          QLog.d("QIMRedDotConfig", 2, localStringBuilder.toString());
        }
        return false;
      }
      this.isComboShowing = true;
      return true;
    }
    this.comboFirstShowTime = System.currentTimeMillis();
    this.isComboShowing = true;
    this.update = true;
    return true;
  }
  
  public boolean showIconRedDot()
  {
    if (!this.showRedDot) {
      return false;
    }
    StringBuilder localStringBuilder;
    if (this.hasShow)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("showIconRedDot hasShow | type=");
        localStringBuilder.append(this.type);
        QLog.d("QIMRedDotConfig", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (this.firstShowTime > 0L)
    {
      if (System.currentTimeMillis() - this.firstShowTime >= 86400000L)
      {
        this.hasShow = true;
        this.update = true;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("showIconRedDot out of time | type=");
          localStringBuilder.append(this.type);
          QLog.d("QIMRedDotConfig", 2, localStringBuilder.toString());
        }
        return false;
      }
      this.isShowing = true;
      return true;
    }
    this.firstShowTime = System.currentTimeMillis();
    this.isShowing = true;
    this.update = true;
    return true;
  }
  
  public boolean showRedDot(int paramInt, String paramString)
  {
    if (!this.redDotItems.isEmpty())
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (paramString.equals(this.defaultUseId)) {
        return false;
      }
      paramString = (QIMRedDotConfig.RedDotItemConfig)this.redDotItems.get(paramString);
      if (paramString != null)
      {
        StringBuilder localStringBuilder;
        if (!paramString.hasShow)
        {
          if (paramString.firstShowTime > 0L)
          {
            if (System.currentTimeMillis() - paramString.firstShowTime < 86400000L)
            {
              paramString.isShowing = true;
              return true;
            }
            this.update = true;
            paramString.hasShow = true;
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("showRedDot out of time | id=");
              localStringBuilder.append(paramString.filterId);
              QLog.d("QIMRedDotConfig", 2, localStringBuilder.toString());
              return false;
            }
          }
          else
          {
            this.update = true;
            paramString.firstShowTime = System.currentTimeMillis();
            paramString.isShowing = true;
            return true;
          }
        }
        else if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("showRedDot hasShow | id=");
          localStringBuilder.append(paramString.filterId);
          QLog.d("QIMRedDotConfig", 2, localStringBuilder.toString());
        }
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("QIMRedDotConfig{");
    localStringBuilder.append("type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", iconVersion=");
    localStringBuilder.append(this.iconVersion);
    localStringBuilder.append(", showRedDot=");
    localStringBuilder.append(this.showRedDot);
    localStringBuilder.append(", hasShow=");
    localStringBuilder.append(this.hasShow);
    localStringBuilder.append(", firstShowTime=");
    localStringBuilder.append(this.firstShowTime);
    localStringBuilder.append(", comboIconVersion=");
    localStringBuilder.append(this.comboIconVersion);
    localStringBuilder.append(", comboShowRedDot=");
    localStringBuilder.append(this.comboShowRedDot);
    localStringBuilder.append(", comboHasShow=");
    localStringBuilder.append(this.comboHasShow);
    localStringBuilder.append(", comboFirstShowTime=");
    localStringBuilder.append(this.comboFirstShowTime);
    localStringBuilder.append(", defaultUseVer=");
    localStringBuilder.append(this.defaultUseVer);
    localStringBuilder.append(", defaultUseId='");
    localStringBuilder.append(this.defaultUseId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", hasUse=");
    localStringBuilder.append(this.hasUse);
    localStringBuilder.append(", defaultCategoryVer=");
    localStringBuilder.append(this.defaultCategoryVer);
    localStringBuilder.append(", defaultCategoryId=");
    localStringBuilder.append(this.defaultCategoryId);
    localStringBuilder.append(", hasChoose=");
    localStringBuilder.append(this.hasChoose);
    localStringBuilder.append(", redDotVersion=");
    localStringBuilder.append(this.redDotVersion);
    localStringBuilder.append(", redDotItems=");
    localStringBuilder.append(this.redDotItems);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public boolean updateRedDotInfo(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool2 = false;
    switch (paramInt1)
    {
    default: 
      bool1 = bool2;
      break;
    case 7: 
      bool1 = bool2;
      if (this.comboDefaultCategoryId == -1) {
        break label353;
      }
      bool1 = bool2;
      if (this.comboHasChoose) {
        break label353;
      }
      this.comboHasChoose = true;
      break;
    case 6: 
      bool1 = bool2;
      if (!this.isComboShowing) {
        break label353;
      }
      bool1 = bool2;
      if (this.comboHasShow) {
        break label353;
      }
      this.comboHasShow = true;
      this.comboFirstShowTime = 0L;
      this.isComboShowing = false;
      break;
    case 5: 
      bool1 = bool2;
      if (this.defaultCategoryId == -1) {
        break label353;
      }
      bool1 = bool2;
      if (this.hasChoose) {
        break label353;
      }
      this.hasChoose = true;
      break;
    case 4: 
      bool1 = bool2;
      if (TextUtils.isEmpty(this.defaultUseId)) {
        break label353;
      }
      bool1 = bool2;
      if (this.hasUse) {
        break label353;
      }
      this.hasUse = true;
      break;
    case 3: 
      paramString = (QIMRedDotConfig.RedDotItemConfig)this.redDotItems.get(paramString);
      bool1 = bool2;
      if (paramString == null) {
        break label353;
      }
      bool1 = bool2;
      if (!paramString.isShowing) {
        break label353;
      }
      bool1 = bool2;
      if (paramString.hasShow) {
        break label353;
      }
      paramString.hasShow = true;
      paramString.firstShowTime = 0L;
      paramString.isShowing = false;
      break;
    case 2: 
      paramString = (QIMRedDotConfig.CategoryRedConfig)this.categories.get(Integer.valueOf(paramInt2));
      bool1 = bool2;
      if (paramString == null) {
        break label353;
      }
      bool1 = bool2;
      if (!paramString.isShowing) {
        break label353;
      }
      bool1 = bool2;
      if (paramString.hasShow) {
        break label353;
      }
      paramString.hasShow = true;
      paramString.firstShowTime = 0L;
      paramString.isShowing = false;
      break;
    case 1: 
      bool1 = bool2;
      if (!this.isShowing) {
        break label353;
      }
      bool1 = bool2;
      if (this.hasShow) {
        break label353;
      }
      this.hasShow = true;
      this.firstShowTime = 0L;
      this.isShowing = false;
    }
    boolean bool1 = true;
    label353:
    if (bool1) {
      this.update = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.QIMRedDotConfig
 * JD-Core Version:    0.7.0.1
 */