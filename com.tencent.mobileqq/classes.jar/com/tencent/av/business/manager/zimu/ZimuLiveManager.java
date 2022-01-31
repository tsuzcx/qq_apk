package com.tencent.av.business.manager.zimu;

import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.doodle.DoodleUtils;
import com.tencent.av.ui.funchat.zimu.ZimuViewLiveAdapter.ZimuViewLiveAdapterItem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ZimuLiveManager
  extends EffectConfigBase
{
  private SimpleDateFormat a;
  public final ArrayList a;
  public boolean a;
  public String c;
  
  public ZimuLiveManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  }
  
  private boolean a(String paramString, List paramList)
  {
    paramList = paramList.iterator();
    label139:
    while (paramList.hasNext())
    {
      ZimuLiveItem localZimuLiveItem = (ZimuLiveItem)paramList.next();
      String[] arrayOfString = localZimuLiveItem.getText().split(",");
      int j = arrayOfString.length;
      int i = 0;
      if (i < j) {
        if (!paramString.contains(arrayOfString[i])) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label139;
        }
        paramList = localZimuLiveItem.getId();
        paramString = null;
        if (paramList.equals("AV0015")) {
          paramString = "0X8008FF1";
        }
        for (;;)
        {
          if (paramString != null) {
            DoodleUtils.a(paramString);
          }
          a(Integer.valueOf(6100), paramList, Boolean.valueOf(false));
          return true;
          i += 1;
          break;
          if (paramList.equals("AV0016")) {
            paramString = "0X8008FF0";
          }
        }
      }
    }
    return false;
  }
  
  private boolean c(String paramString)
  {
    String str = null;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (!localJSONObject.has("liveshow_painted_eggshell")) {
          break label246;
        }
        bool = localJSONObject.getBoolean("liveshow_painted_eggshell");
        AVLog.c("ZimuLiveManager", "parsePaintedEggshell paintedEggshell = " + this.jdField_a_of_type_Boolean);
        if (!localJSONObject.has("liveshow_painted_eggshell_start_time")) {
          break label241;
        }
        paramString = localJSONObject.getString("liveshow_painted_eggshell_start_time");
        if (localJSONObject.has("liveshow_painted_eggshell_end_time")) {
          str = localJSONObject.getString("liveshow_painted_eggshell_end_time");
        }
        if ((bool) && (paramString != null) && (str != null))
        {
          try
          {
            long l1 = this.jdField_a_of_type_JavaTextSimpleDateFormat.parse(paramString).getTime();
            long l2 = this.jdField_a_of_type_JavaTextSimpleDateFormat.parse(str).getTime();
            long l3 = System.currentTimeMillis();
            if ((l1 < l3) && (l3 < l2))
            {
              this.jdField_a_of_type_Boolean = true;
              return true;
            }
            this.jdField_a_of_type_Boolean = false;
            return true;
          }
          catch (ParseException paramString)
          {
            this.jdField_a_of_type_Boolean = false;
            AVLog.c("ZimuLiveManager", "parsePaintedEggshell e = " + paramString);
            return true;
          }
          return false;
        }
      }
      catch (JSONException paramString)
      {
        AVLog.c("ZimuLiveManager", "parsePaintedEggshell e = " + paramString);
      }
      this.jdField_a_of_type_Boolean = false;
      return true;
      label241:
      paramString = null;
      continue;
      label246:
      boolean bool = false;
    }
  }
  
  public int a()
  {
    return 216;
  }
  
  protected Class a()
  {
    return ZimuLiveItem.class;
  }
  
  protected void a(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    AVLog.c("ZimuLiveManager", "notifyEvent :" + paramInteger + "|" + paramObject1 + "|" + paramObject2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public boolean a(SentenceInfo paramSentenceInfo, boolean paramBoolean)
  {
    boolean bool = false;
    if ((paramBoolean) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      return true;
    }
    if (paramSentenceInfo.jdField_a_of_type_JavaLangCharSequence.equals("。")) {
      return true;
    }
    Object localObject = paramSentenceInfo.jdField_a_of_type_JavaLangCharSequence.toString().toLowerCase();
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    ZimuViewLiveAdapter.ZimuViewLiveAdapterItem localZimuViewLiveAdapterItem;
    if (i < j)
    {
      localZimuViewLiveAdapterItem = (ZimuViewLiveAdapter.ZimuViewLiveAdapterItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (((!localZimuViewLiveAdapterItem.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.a()) || (localZimuViewLiveAdapterItem.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.equals(paramSentenceInfo))) && (localZimuViewLiveAdapterItem.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.jdField_a_of_type_JavaLangString.equals(paramSentenceInfo.jdField_a_of_type_JavaLangString)))
      {
        localZimuViewLiveAdapterItem.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo = paramSentenceInfo;
        bool = true;
      }
    }
    for (;;)
    {
      if (!bool)
      {
        localZimuViewLiveAdapterItem = new ZimuViewLiveAdapter.ZimuViewLiveAdapterItem();
        localZimuViewLiveAdapterItem.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo = paramSentenceInfo;
        localZimuViewLiveAdapterItem.jdField_a_of_type_Boolean = paramBoolean;
        this.jdField_a_of_type_JavaUtilArrayList.add(localZimuViewLiveAdapterItem);
      }
      List localList = a(null);
      if (this.jdField_a_of_type_Boolean)
      {
        if (paramSentenceInfo.jdField_a_of_type_Boolean) {
          a((String)localObject, localList);
        }
      }
      else
      {
        return bool;
        i += 1;
        break;
      }
      localObject = ((String)localObject).split("，");
      j = localZimuViewLiveAdapterItem.jdField_a_of_type_Int;
      if (paramSentenceInfo.a()) {
        i = localObject.length;
      }
      for (;;)
      {
        if ((j >= i) || (a(localObject[j], localList)))
        {
          localZimuViewLiveAdapterItem.jdField_a_of_type_Int = i;
          break;
          i = localObject.length - 1;
          continue;
        }
        j += 1;
      }
      localZimuViewLiveAdapterItem = null;
    }
  }
  
  protected boolean a(String paramString)
  {
    return c(paramString);
  }
  
  protected String b()
  {
    return "resources";
  }
  
  protected List b(String paramString)
  {
    List localList = super.b(paramString);
    c(paramString);
    return localList;
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.business.manager.zimu.ZimuLiveManager
 * JD-Core Version:    0.7.0.1
 */