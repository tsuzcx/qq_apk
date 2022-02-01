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
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f;
  public static SparseArray<String> g = new SparseArray();
  public static ArrayList<PEItemData> h = new ArrayList();
  public static volatile boolean i = false;
  public static String j;
  public static Typeface k;
  public static volatile boolean l;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PE));
    localStringBuilder.append(File.separator);
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("res/");
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("lottie/");
    c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("font/");
    d = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("summary/");
    e = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append("sticker_bubble_animation.ttf");
    f = localStringBuilder.toString();
  }
  
  public static String a(int paramInt)
  {
    if (g.size() == 0) {
      a();
    }
    String str2 = (String)g.get(paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = HardCodeUtil.a(2131905733);
    }
    return str1;
  }
  
  public static void a()
  {
    try
    {
      boolean bool = i;
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
            int m = Integer.parseInt((String)localObject4);
            g.put(m, str);
          }
          i = true;
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
    if (!new File(a).exists()) {
      return false;
    }
    QQAlbumUtils.a(a);
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
        int n = paramString.length;
        int m = 0;
        bool1 = true;
        while (m < n) {
          try
          {
            bool2 = new File(b(Integer.parseInt(paramString[m]))).exists();
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
            m += 1;
          }
        }
      }
    }
    return bool1;
  }
  
  public static String b(int paramInt)
  {
    return String.format("%spe_%d.gif", new Object[] { b, Integer.valueOf(paramInt) });
  }
  
  public static List<PEItemData> b(String paramString)
  {
    if ((paramString != null) && (paramString.equals(j))) {
      return h;
    }
    h.clear();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(",");
      if ((paramString != null) && (paramString.length > 0))
      {
        int n = paramString.length;
        int m = 0;
        while (m < n)
        {
          try
          {
            int i1 = Integer.parseInt(paramString[m]);
            PEItemData localPEItemData = new PEItemData();
            localPEItemData.a = i1;
            localPEItemData.b = b(i1);
            h.add(localPEItemData);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          m += 1;
        }
      }
    }
    return h;
  }
  
  public static void b()
  {
    if (k != null) {
      return;
    }
    try
    {
      File localFile = new File(f);
      if (localFile.exists()) {
        k = Typeface.createFromFile(localFile);
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
      k = null;
      l = false;
    }
  }
  
  public static Drawable c(int paramInt)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    String str = b(paramInt);
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130842390);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130842390);
    localObject = URLDrawable.getDrawable(new File(str), (URLDrawable.URLDrawableOptions)localObject);
    if (((URLDrawable)localObject).getStatus() == 2) {
      ((URLDrawable)localObject).restartDownload();
    }
    return localObject;
  }
  
  public static PEItemData d(int paramInt)
  {
    if (h.size() > paramInt) {
      return (PEItemData)h.get(paramInt);
    }
    return null;
  }
  
  public static PEItemData e(int paramInt)
  {
    if (h.size() != 0)
    {
      localObject = h.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localPEItemData = (PEItemData)((Iterator)localObject).next();
        if (localPEItemData.a == paramInt) {
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
      ((PEItemData)localObject).a = paramInt;
      ((PEItemData)localObject).b = b(paramInt);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.PEPanelHelper
 * JD-Core Version:    0.7.0.1
 */