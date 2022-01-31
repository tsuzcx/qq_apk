package com.tencent.biz.qqstory.storyHome.qqstorylist;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.AddressHelper;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import nze;
import nzf;

public class LocalVideoPusher
  implements Handler.Callback, ILocalVideoPusher
{
  public static String a;
  public static final HashMap a;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private ContentObserver jdField_a_of_type_AndroidDatabaseContentObserver = new nze(this, new Handler());
  protected Handler a;
  private LocalVideoPusher.EventCallBack jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher$EventCallBack;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  public Handler b;
  private ArrayList b;
  public boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.qqstory.Home.LocalVideoPusher";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("1月1日", "新年");
    jdField_a_of_type_JavaUtilHashMap.put("1月2日", "新年");
    jdField_a_of_type_JavaUtilHashMap.put("1月3日", "新年");
    jdField_a_of_type_JavaUtilHashMap.put("1月20日", "小年");
    jdField_a_of_type_JavaUtilHashMap.put("1月27日", "除夕");
    jdField_a_of_type_JavaUtilHashMap.put("1月28日", "春节");
    jdField_a_of_type_JavaUtilHashMap.put("1月29日", "春节");
    jdField_a_of_type_JavaUtilHashMap.put("1月30日", "春节");
    jdField_a_of_type_JavaUtilHashMap.put("2月1日", "春节");
    jdField_a_of_type_JavaUtilHashMap.put("2月2日", "春节");
    jdField_a_of_type_JavaUtilHashMap.put("2月3日", "春节");
    jdField_a_of_type_JavaUtilHashMap.put("2月4日", "春节");
    jdField_a_of_type_JavaUtilHashMap.put("2月11日", "元宵节");
    jdField_a_of_type_JavaUtilHashMap.put("2月14日", "情人节");
    jdField_a_of_type_JavaUtilHashMap.put("4月1日", "愚人节");
    jdField_a_of_type_JavaUtilHashMap.put("4月16日", "复活节");
    jdField_a_of_type_JavaUtilHashMap.put("5月4日", "青年节");
    jdField_a_of_type_JavaUtilHashMap.put("5月14日", "母亲节");
    jdField_a_of_type_JavaUtilHashMap.put("5月30日", "端午");
    jdField_a_of_type_JavaUtilHashMap.put("6月1日", "儿童节");
    jdField_a_of_type_JavaUtilHashMap.put("6月18日", "父亲节");
    jdField_a_of_type_JavaUtilHashMap.put("8月28日", "七夕");
    jdField_a_of_type_JavaUtilHashMap.put("10月1日", "国庆节");
    jdField_a_of_type_JavaUtilHashMap.put("10月2日", "国庆节");
    jdField_a_of_type_JavaUtilHashMap.put("10月3日", "国庆节");
    jdField_a_of_type_JavaUtilHashMap.put("10月4日", "国庆节");
    jdField_a_of_type_JavaUtilHashMap.put("10月5日", "国庆节");
    jdField_a_of_type_JavaUtilHashMap.put("10月6日", "国庆节");
    jdField_a_of_type_JavaUtilHashMap.put("10月7日", "国庆节");
    jdField_a_of_type_JavaUtilHashMap.put("11月1日", "万圣节");
    jdField_a_of_type_JavaUtilHashMap.put("11月2日", "感恩节");
    jdField_a_of_type_JavaUtilHashMap.put("11月11日", "光棍节");
    jdField_a_of_type_JavaUtilHashMap.put("12月24日", "平安夜");
    jdField_a_of_type_JavaUtilHashMap.put("12月25日", "圣诞节");
  }
  
  public LocalVideoPusher(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private Cursor a(Context paramContext)
  {
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L - 86400L;
    if (l > this.jdField_a_of_type_Long) {
      this.jdField_a_of_type_Long = l;
    }
    String str = "date_added >=" + this.jdField_a_of_type_Long + " and (" + "_data" + " like '%/DCIM/%' or " + "_data" + " like '%/相机/%')";
    try
    {
      paramContext = paramContext.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_data", "date_added", "date_modified", "latitude", "longitude", "duration", "_size", "width", "height", "mime_type" }, str, null, "date_modified desc");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      SLog.e(jdField_a_of_type_JavaLangString, "query error:" + paramContext);
    }
    return null;
  }
  
  private ArrayList a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      LocalMediaInfo localLocalMediaInfo;
      try
      {
        paramContext = a(paramContext);
        if (paramContext == null) {
          return localArrayList;
        }
        paramContext.moveToFirst();
        int i = paramContext.getColumnIndex("_id");
        int j = paramContext.getColumnIndex("date_added");
        int k = paramContext.getColumnIndex("date_modified");
        int m = paramContext.getColumnIndex("latitude");
        int n = paramContext.getColumnIndex("longitude");
        int i1 = paramContext.getColumnIndex("duration");
        int i2 = paramContext.getColumnIndex("_size");
        int i3 = paramContext.getColumnIndex("mime_type");
        int i4 = paramContext.getColumnIndex("height");
        int i5 = paramContext.getColumnIndex("width");
        String str = paramContext.getString(paramContext.getColumnIndex("_data"));
        localLocalMediaInfo = new LocalMediaInfo();
        localLocalMediaInfo._id = paramContext.getInt(i);
        localLocalMediaInfo.modifiedDate = paramContext.getLong(k);
        localLocalMediaInfo.addedDate = paramContext.getLong(j);
        localLocalMediaInfo.fileSize = paramContext.getLong(i2);
        localLocalMediaInfo.latitude = ((int)(paramContext.getDouble(m) * 1000000.0D));
        localLocalMediaInfo.longitude = ((int)(paramContext.getDouble(n) * 1000000.0D));
        localLocalMediaInfo.mDuration = paramContext.getLong(i1);
        localLocalMediaInfo.mMimeType = paramContext.getString(i3);
        localLocalMediaInfo.mediaHeight = paramContext.getInt(i4);
        localLocalMediaInfo.mediaWidth = paramContext.getInt(i5);
        localLocalMediaInfo.path = str;
        if (!a(localLocalMediaInfo))
        {
          localArrayList.add(localLocalMediaInfo);
          if (paramContext.moveToNext()) {
            continue;
          }
          paramContext.close();
          return localArrayList;
        }
      }
      catch (Exception paramContext)
      {
        SLog.e(jdField_a_of_type_JavaLangString, "translate error:" + paramContext);
        return localArrayList;
      }
      SLog.b(jdField_a_of_type_JavaLangString, "过滤掉:" + localLocalMediaInfo);
    }
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((LocalVideoPusher.Filter)localIterator.next()).a(paramLocalMediaInfo)) {
        return true;
      }
    }
    return false;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(Integer.valueOf(1));
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(Integer.valueOf(2));
    }
  }
  
  public ILocalVideoPusher a(LocalVideoPusher.Condition paramCondition)
  {
    this.jdField_b_of_type_JavaUtilArrayList.add(paramCondition);
    return this;
  }
  
  public ILocalVideoPusher a(LocalVideoPusher.Filter paramFilter)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramFilter);
    return this;
  }
  
  public String a(long paramLong)
  {
    Object localObject;
    if (paramLong == 0L) {
      localObject = "";
    }
    String str2;
    String str1;
    do
    {
      return localObject;
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTimeInMillis(1000L * paramLong);
      int i = ((Calendar)localObject).get(1);
      str2 = String.format("%d月%d日", new Object[] { Integer.valueOf(((Calendar)localObject).get(2) + 1), Integer.valueOf(((Calendar)localObject).get(5)) });
      if (i != 2017) {
        break;
      }
      str1 = (String)jdField_a_of_type_JavaUtilHashMap.get(str2);
      localObject = str1;
    } while (!TextUtils.isEmpty(str1));
    return str2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null)
    {
      SLog.e(jdField_a_of_type_JavaLangString, " illegal operate : start when context is null");
      return;
    }
    this.jdField_a_of_type_AndroidContentContext.getContentResolver().registerContentObserver(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, false, this.jdField_a_of_type_AndroidDatabaseContentObserver);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = (paramLong / 1000L);
  }
  
  public void a(LocalVideoPusher.EventCallBack paramEventCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher$EventCallBack = paramEventCallBack;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      b();
    }
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    d();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (!((LocalVideoPusher.Condition)localIterator.next()).a())
      {
        SLog.b(jdField_a_of_type_JavaLangString, "条件没有被允许");
        return;
      }
    }
    if (this.jdField_a_of_type_AndroidContentContext == null)
    {
      SLog.e(jdField_a_of_type_JavaLangString, " illegal operate : run when context is null");
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void c()
  {
    d();
    this.jdField_a_of_type_AndroidContentContext.getContentResolver().unregisterContentObserver(this.jdField_a_of_type_AndroidDatabaseContentObserver);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher$EventCallBack = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        paramMessage = a(this.jdField_a_of_type_AndroidContentContext);
      } while ((paramMessage == null) || (paramMessage.size() == 0));
      AddressHelper localAddressHelper = new AddressHelper();
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramMessage.get(0);
      localAddressHelper.a(localLocalMediaInfo.latitude, localLocalMediaInfo.longitude, new nzf(this, paramMessage, localLocalMediaInfo));
      return true;
    } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher$EventCallBack == null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher$EventCallBack.a((LocalVideoPusher.Response)paramMessage.obj);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.LocalVideoPusher
 * JD-Core Version:    0.7.0.1
 */