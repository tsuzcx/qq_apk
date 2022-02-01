package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.album.QQAlbumUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class PEPanelHelper
{
  public static Typeface a;
  public static SparseArray<String> a;
  public static final String a;
  public static ArrayList<PEItemData> a;
  public static volatile boolean a;
  public static final String b;
  public static volatile boolean b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f;
  public static String g;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PE));
    localStringBuilder.append(File.separator);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("res/");
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("lottie/");
    c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("font/");
    d = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("summary/");
    e = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append("sticker_bubble_animation.ttf");
    f = localStringBuilder.toString();
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_Boolean = false;
  }
  
  public static Drawable a(int paramInt)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    String str = b(paramInt);
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130841546);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130841546);
    localObject = URLDrawable.getDrawable(new File(str), (URLDrawable.URLDrawableOptions)localObject);
    if (((URLDrawable)localObject).getStatus() == 2) {
      ((URLDrawable)localObject).restartDownload();
    }
    return localObject;
  }
  
  public static PEItemData a(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilArrayList.size() > paramInt) {
      return (PEItemData)jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public static String a(int paramInt)
  {
    if (jdField_a_of_type_AndroidUtilSparseArray.size() == 0) {
      a();
    }
    String str2 = (String)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = HardCodeUtil.a(2131707919);
    }
    return str1;
  }
  
  public static List<PEItemData> a(String paramString)
  {
    if ((paramString != null) && (paramString.equals(g))) {
      return jdField_a_of_type_JavaUtilArrayList;
    }
    jdField_a_of_type_JavaUtilArrayList.clear();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(",");
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          try
          {
            int k = Integer.parseInt(paramString[i]);
            PEItemData localPEItemData = new PEItemData();
            localPEItemData.jdField_a_of_type_Int = k;
            localPEItemData.jdField_a_of_type_JavaLangString = b(k);
            jdField_a_of_type_JavaUtilArrayList.add(localPEItemData);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          i += 1;
        }
      }
    }
    return jdField_a_of_type_JavaUtilArrayList;
  }
  
  public static void a()
  {
    try
    {
      boolean bool = jdField_a_of_type_Boolean;
      if (bool) {
        return;
      }
      Object localObject1 = new File(e);
      bool = ((File)localObject1).exists();
      if (!bool) {
        return;
      }
      localObject1 = ((File)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject1 = localObject1[0];
        Iterator localIterator = null;
        Object localObject4;
        Object localObject2;
        try
        {
          localObject4 = FileUtils.getByte((File)localObject1);
          localObject1 = localIterator;
          if (localObject4 != null) {
            localObject1 = new String((byte[])localObject4, "UTF-8");
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          localObject2 = localIterator;
        }
        bool = TextUtils.isEmpty((CharSequence)localObject2);
        if (bool) {
          return;
        }
        try
        {
          localObject2 = new JSONObject((String)localObject2);
          localIterator = ((JSONObject)localObject2).keys();
          while (localIterator.hasNext())
          {
            localObject4 = (String)localIterator.next();
            String str = (String)((JSONObject)localObject2).get((String)localObject4);
            int i = Integer.parseInt((String)localObject4);
            jdField_a_of_type_AndroidUtilSparseArray.put(i, str);
          }
          jdField_a_of_type_Boolean = true;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public static boolean a(String paramString)
  {
    if (!new File(jdField_a_of_type_JavaLangString).exists()) {
      return false;
    }
    QQAlbumUtils.a(jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.split(",");
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length > 0)
      {
        int j = paramString.length;
        int i = 0;
        bool1 = true;
        while (i < j) {
          try
          {
            bool2 = new File(b(Integer.parseInt(paramString[i]))).exists();
            if (!bool2) {
              return false;
            }
          }
          catch (Exception localException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkPEResValid + exception :");
            localStringBuilder.append(localException);
            QLog.d("PokeEmo", 1, localStringBuilder.toString());
            bool1 = false;
            i += 1;
          }
        }
      }
    }
    return bool1;
  }
  
  public static PEItemData b(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilArrayList.size() != 0)
    {
      localObject = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localPEItemData = (PEItemData)((Iterator)localObject).next();
        if (localPEItemData.jdField_a_of_type_Int == paramInt) {
          break label48;
        }
      }
    }
    PEItemData localPEItemData = null;
    label48:
    Object localObject = localPEItemData;
    if (localPEItemData == null)
    {
      localObject = new PEItemData();
      ((PEItemData)localObject).jdField_a_of_type_Int = paramInt;
      ((PEItemData)localObject).jdField_a_of_type_JavaLangString = b(paramInt);
    }
    return localObject;
  }
  
  public static String b(int paramInt)
  {
    return String.format("%spe_%d.gif", new Object[] { jdField_b_of_type_JavaLangString, Integer.valueOf(paramInt) });
  }
  
  public static void b()
  {
    if (jdField_a_of_type_AndroidGraphicsTypeface != null) {
      return;
    }
    try
    {
      File localFile = new File(f);
      if (localFile.exists()) {
        jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(localFile);
      }
      QLog.e("PokeEmo", 1, "loadFont success ");
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadFont failed ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("PokeEmo", 1, localStringBuilder.toString());
      jdField_a_of_type_AndroidGraphicsTypeface = null;
      jdField_b_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.PEPanelHelper
 * JD-Core Version:    0.7.0.1
 */