import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.part.QIMTemplateItem;
import dov.com.qq.im.capture.view.ComboProviderView;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMFilterProviderView;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class blrx
  extends blrr
  implements Handler.Callback, IEventReceiver
{
  public static int a;
  public Handler a;
  private blsj jdField_a_of_type_Blsj;
  public blsn a;
  public blsq a;
  public bnhc a;
  public ArrayList<QIMTemplateItem> a;
  public HashMap<String, blsn> a;
  public uul a;
  private boolean jdField_a_of_type_Boolean;
  public blsb[] a;
  int b;
  public Handler b;
  public ArrayList<QIMTemplateItem> b;
  public HashMap<String, blsq> b;
  public Handler c;
  public ArrayList<QIMFilterCategoryItem> c;
  public HashMap<String, blru> c;
  public ArrayList<QIMFilterCategoryItem> d;
  public HashMap<String, blsx> d;
  ArrayList<blsa> e;
  public HashMap<String, ArrayList<blsc>> e;
  
  static
  {
    jdField_a_of_type_Int = 4;
  }
  
  public blrx()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_d_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new blrz(this));
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_e_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ArrayOfBlsb = new blsb[5];
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBlsb.length)
    {
      this.jdField_a_of_type_ArrayOfBlsb[i] = new blsb(i);
      i += 1;
    }
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), new blry(this));
    this.jdField_a_of_type_Blsj = new blsj();
  }
  
  private void a(Activity paramActivity, int paramInt)
  {
    blsn localblsn = bnhb.a().a[paramInt];
    if (localblsn != null) {
      localblsn.a(paramActivity, paramInt);
    }
    bnhb.a().a(null, paramActivity, paramInt);
  }
  
  private static boolean a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if ((paramQIMFilterCategoryItem != null) && (paramQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList != null))
    {
      paramQIMFilterCategoryItem = paramQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramQIMFilterCategoryItem.hasNext()) {
        if ("EMPTY".equals((String)paramQIMFilterCategoryItem.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void b(Activity paramActivity, int paramInt)
  {
    blsg localblsg = (blsg)blqr.a(15);
    blsx localblsx = localblsg.a();
    if (localblsx != null)
    {
      localblsx.a(paramActivity, paramInt);
      if (paramInt == 0) {
        localblsg.a(null);
      }
    }
  }
  
  public blru a(FilterDesc paramFilterDesc)
  {
    blru localblru2 = (blru)this.jdField_c_of_type_JavaUtilHashMap.get(paramFilterDesc.name);
    blru localblru1 = localblru2;
    if (localblru2 == null)
    {
      localblru1 = new blru(paramFilterDesc);
      this.jdField_c_of_type_JavaUtilHashMap.put(paramFilterDesc.name, localblru1);
    }
    return localblru1;
  }
  
  public blsb a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfBlsb[paramInt];
  }
  
  public blsj a()
  {
    return this.jdField_a_of_type_Blsj;
  }
  
  public blsn a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    blsn localblsn2 = (blsn)this.jdField_a_of_type_JavaUtilHashMap.get(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    Object localObject1 = localblsn2;
    Object localObject2;
    Object localObject3;
    int j;
    int i;
    int n;
    int k;
    int m;
    if (localblsn2 == null)
    {
      localblsn2 = new blsn(paramQIMFilterCategoryItem);
      localObject1 = paramQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = bnhb.a().a((String)localObject2);
        if (localObject3 != null) {
          localblsn2.c(a((FilterDesc)localObject3));
        } else if (QLog.isColorLevel()) {
          QLog.d("QCombo", 2, "createCombo filter Null " + (String)localObject2);
        }
      }
      j = 0;
      i = 0;
      if (paramQIMFilterCategoryItem.jdField_a_of_type_OrgJsonJSONArray != null)
      {
        n = paramQIMFilterCategoryItem.jdField_a_of_type_OrgJsonJSONArray.length();
        k = 0;
        j = i;
        if (k < n)
        {
          localObject3 = paramQIMFilterCategoryItem.jdField_a_of_type_OrgJsonJSONArray.optJSONObject(k);
          if (localObject3 == null) {
            break label1280;
          }
          for (;;)
          {
            try
            {
              localObject4 = ((JSONObject)localObject3).optString("packet_id");
              localObject1 = ((JSONObject)localObject3).optString("item_id");
              f1 = Float.valueOf(((JSONObject)localObject3).optString("position_x")).floatValue();
              f2 = Float.valueOf(((JSONObject)localObject3).optString("position_y")).floatValue();
              f3 = Float.valueOf(((JSONObject)localObject3).optString("scale")).floatValue();
              localObject2 = new SegmentKeeper();
              ((SegmentKeeper)localObject2).fromJSONObject((JSONObject)localObject3);
              localObject3 = blve.a(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, (String)localObject4, (String)localObject1, f1, f2, f3);
              if (localObject3 != null)
              {
                ((blrs)localObject3).a((SegmentKeeper)localObject2);
                localblsn2.c((blrs)localObject3);
                k += 1;
                break;
              }
              m = 1;
              j = 1;
              i = j;
              try
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("QCombo", 2, "createCombo pasters Null item_id= " + (String)localObject1);
                i = j;
              }
              catch (Exception localException1)
              {
                i = m;
              }
            }
            catch (Exception localException5)
            {
              Object localObject4;
              float f1;
              float f2;
              float f3;
              int i1;
              String str1;
              String str2;
              continue;
            }
            localException1.printStackTrace();
          }
        }
      }
      if (paramQIMFilterCategoryItem.jdField_b_of_type_OrgJsonJSONArray != null)
      {
        i1 = paramQIMFilterCategoryItem.jdField_b_of_type_OrgJsonJSONArray.length();
        m = 0;
        i = j;
        label393:
        j = i;
        if (m < i1)
        {
          localObject2 = paramQIMFilterCategoryItem.jdField_b_of_type_OrgJsonJSONArray.optJSONObject(m);
          j = i;
          if (localObject2 == null) {
            break label1283;
          }
          k = i;
          try
          {
            str1 = ((JSONObject)localObject2).optString("tagId");
            k = i;
            localObject2 = ((JSONObject)localObject2).optString("itemId");
            k = i;
            localObject3 = blve.a((String)localObject2);
            if (localObject3 != null)
            {
              k = i;
              localblsn2.c((blrs)localObject3);
              j = i;
            }
            else
            {
              n = 1;
              i = 1;
              k = i;
              j = n;
              if (QLog.isColorLevel())
              {
                k = i;
                QLog.d("QCombo", 2, "createCombo musicNull " + str1 + ":" + (String)localObject2);
                j = n;
              }
            }
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            j = k;
          }
        }
      }
      i = j;
      if (paramQIMFilterCategoryItem.c != null)
      {
        i1 = paramQIMFilterCategoryItem.c.length();
        m = 0;
        label592:
        i = j;
        if (m < i1)
        {
          localObject2 = paramQIMFilterCategoryItem.c.optJSONObject(m);
          i = j;
          if (localObject2 == null) {
            break label1296;
          }
          k = j;
          try
          {
            str2 = ((JSONObject)localObject2).optString("tagId");
            k = j;
            localObject2 = ((JSONObject)localObject2).optString("itemId");
            k = j;
            i = j;
            if (bdnn.a(str2)) {
              break label1296;
            }
            k = j;
            localObject3 = blve.b((String)localObject2);
            if (localObject3 != null)
            {
              k = j;
              localblsn2.c((blrs)localObject3);
              i = j;
            }
            else
            {
              n = 1;
              j = 1;
              k = j;
              i = n;
              if (QLog.isColorLevel())
              {
                k = j;
                QLog.d("QCombo", 2, "createCombo ptvNull " + str2 + ":" + (String)localObject2);
                i = n;
              }
            }
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
            i = k;
          }
        }
      }
      j = i;
      if (paramQIMFilterCategoryItem.d != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QCombo", 2, "createCombo texts " + paramQIMFilterCategoryItem.d + " size: " + paramQIMFilterCategoryItem.d.length());
        }
        i1 = paramQIMFilterCategoryItem.d.length();
        m = 0;
      }
    }
    for (;;)
    {
      j = i;
      if (m < i1)
      {
        localObject2 = paramQIMFilterCategoryItem.d.optJSONObject(m);
        k = i;
        if (localObject2 != null) {
          j = i;
        }
      }
      else
      {
        for (;;)
        {
          try
          {
            String str3 = ((JSONObject)localObject2).optString("text_id");
            j = i;
            localObject4 = ((JSONObject)localObject2).optJSONArray("texts");
            k = i;
            if (localObject4 == null) {
              break label1318;
            }
            j = i;
            localObject3 = new ArrayList();
            k = 0;
            j = i;
            if (k < ((JSONArray)localObject4).length())
            {
              j = i;
              String str4 = ((JSONArray)localObject4).getString(k);
              j = i;
              if (TextUtils.isEmpty(str4)) {
                break label1309;
              }
              j = i;
              ((List)localObject3).add(str4);
              break label1309;
            }
            j = i;
            f1 = Float.valueOf(((JSONObject)localObject2).optString("position_x")).floatValue();
            j = i;
            f2 = Float.valueOf(((JSONObject)localObject2).optString("position_y")).floatValue();
            j = i;
            f3 = Float.valueOf(((JSONObject)localObject2).optString("scale")).floatValue();
            j = i;
            if (QLog.isColorLevel())
            {
              j = i;
              QLog.d("QCombo", 2, "create  TextCombo ID: " + str3);
            }
            j = i;
            localObject4 = new SegmentKeeper();
            j = i;
            ((SegmentKeeper)localObject4).fromJSONObject((JSONObject)localObject2);
            j = i;
            localObject2 = blve.a(str3, (List)localObject3, f1, f2, f3);
            if (localObject2 != null)
            {
              j = i;
              ((blrs)localObject2).a((SegmentKeeper)localObject4);
              j = i;
              localblsn2.c((blrs)localObject2);
              k = i;
            }
            else
            {
              n = 1;
              i = 1;
              j = i;
              k = n;
              if (QLog.isColorLevel())
              {
                j = i;
                QLog.d("QCombo", 2, "createCombo texts Null id=" + str3);
                k = n;
              }
            }
          }
          catch (Exception localException4)
          {
            localException4.printStackTrace();
            k = j;
          }
          if (j == 0) {
            this.jdField_a_of_type_JavaUtilHashMap.put(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, localblsn2);
          }
          blsn localblsn1 = localblsn2;
          localblsn1.jdField_a_of_type_JavaLangObject = paramQIMFilterCategoryItem;
          return localblsn1;
          label1280:
          break;
          label1283:
          m += 1;
          i = j;
          break label393;
          label1296:
          m += 1;
          j = i;
          break label592;
          label1309:
          k += 1;
        }
      }
      label1318:
      m += 1;
      i = k;
    }
  }
  
  public blsn a(QIMFilterCategoryItem paramQIMFilterCategoryItem, Activity paramActivity, Bundle paramBundle)
  {
    blrx localblrx = (blrx)blqr.a(5);
    blsn localblsn = localblrx.a(paramQIMFilterCategoryItem);
    localblsn.b(paramActivity, paramBundle.getInt("capture_scene", -1));
    localblsn.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    localblrx.a(paramQIMFilterCategoryItem);
    switch (localblsn.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "applyCombo state = " + localblsn.jdField_a_of_type_Int);
      }
      return localblsn;
      a(new blsc(localblsn, paramBundle, paramActivity));
      paramQIMFilterCategoryItem = Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 7, 0, 0, localblsn);
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        a(paramQIMFilterCategoryItem);
      }
      else
      {
        paramQIMFilterCategoryItem.sendToTarget();
        continue;
        a(new blsc(localblsn, paramBundle, paramActivity));
        continue;
        a(new blsc(localblsn, paramBundle, paramActivity));
        localblsn.b();
      }
    }
  }
  
  public blsn a(String paramString)
  {
    Object localObject1 = null;
    blsn localblsn = null;
    Object localObject2 = this.jdField_a_of_type_Bnhc;
    if (localObject2 != null)
    {
      localObject2 = ((bnhc)localObject2).a.jdField_a_of_type_JavaUtilArrayList.iterator();
      localObject1 = localblsn;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((FilterCategory)((Iterator)localObject2).next()).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject1).next();
          if (TextUtils.equals(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, paramString)) {
            localblsn = a(localQIMFilterCategoryItem);
          }
        }
      }
    }
    for (;;)
    {
      break;
      return localObject1;
    }
  }
  
  public blsq a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = bnhb.a().a((String)localObject2);
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
    }
    Object localObject2 = (blsq)this.jdField_b_of_type_JavaUtilHashMap.get(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new blsq(paramQIMFilterCategoryItem);
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((blsq)localObject1).c(a((FilterDesc)((Iterator)localObject2).next()));
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, localObject1);
    }
    return localObject1;
  }
  
  public blsq a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Bnhc;
    if (localObject != null)
    {
      localObject = ((bnhc)localObject).a.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject).next();
        if (TextUtils.equals(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, paramString)) {
          return a(localQIMFilterCategoryItem);
        }
      }
    }
    return null;
  }
  
  public blsx a(QIMTemplateItem paramQIMTemplateItem)
  {
    Object localObject2 = (blsx)this.jdField_d_of_type_JavaUtilHashMap.get(paramQIMTemplateItem.jdField_a_of_type_JavaLangString);
    Object localObject1 = localObject2;
    Object localObject3;
    Object localObject4;
    int j;
    int i;
    Object localObject5;
    float f1;
    float f2;
    float f3;
    label437:
    label586:
    int k;
    if (localObject2 == null)
    {
      localObject1 = new blsx(paramQIMTemplateItem);
      if (QLog.isColorLevel()) {
        QLog.d("QTemplate", 2, "createTemplate filter " + paramQIMTemplateItem.jdField_a_of_type_JavaUtilArrayList);
      }
      localObject2 = paramQIMTemplateItem.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = bnhb.a().a((String)localObject3);
        if (localObject4 != null) {
          ((blsx)localObject1).d(a((FilterDesc)localObject4));
        } else if (QLog.isColorLevel()) {
          QLog.d("QTemplate", 2, "createTemplate filterNull " + (String)localObject3);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QTemplate", 2, "createTemplate pasters " + paramQIMTemplateItem.jdField_a_of_type_OrgJsonJSONArray);
      }
      if (paramQIMTemplateItem.jdField_a_of_type_OrgJsonJSONArray != null)
      {
        j = paramQIMTemplateItem.jdField_a_of_type_OrgJsonJSONArray.length();
        i = 0;
        if (i < j)
        {
          localObject4 = paramQIMTemplateItem.jdField_a_of_type_OrgJsonJSONArray.optJSONObject(i);
          if (localObject4 == null) {
            break label1086;
          }
          try
          {
            localObject5 = ((JSONObject)localObject4).optString("packet_id");
            localObject2 = ((JSONObject)localObject4).optString("item_id");
            f1 = Float.valueOf(((JSONObject)localObject4).optString("position_x")).floatValue();
            f2 = Float.valueOf(((JSONObject)localObject4).optString("position_y")).floatValue();
            f3 = Float.valueOf(((JSONObject)localObject4).optString("scale")).floatValue();
            localObject3 = new SegmentKeeper();
            ((SegmentKeeper)localObject3).fromJSONObject((JSONObject)localObject4);
            localObject4 = blve.a(paramQIMTemplateItem.jdField_a_of_type_JavaLangString, (String)localObject5, (String)localObject2, f1, f2, f3);
            if (localObject4 != null)
            {
              ((blrs)localObject4).a((SegmentKeeper)localObject3);
              ((blsx)localObject1).d((blrs)localObject4);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("QTemplate", 2, "createTemplate pasters Null item_id= " + (String)localObject2);
            }
          }
          catch (Exception localException1)
          {
            QLog.d("CaptureComboManager", 1, "createTemplate exception", localException1);
          }
        }
      }
      if (paramQIMTemplateItem.jdField_b_of_type_OrgJsonJSONArray != null)
      {
        j = paramQIMTemplateItem.jdField_b_of_type_OrgJsonJSONArray.length();
        i = 0;
        if (i < j)
        {
          localObject3 = paramQIMTemplateItem.jdField_b_of_type_OrgJsonJSONArray.optJSONObject(i);
          if (localObject3 == null) {
            break label1095;
          }
          try
          {
            String str1 = ((JSONObject)localObject3).optString("tagId");
            localObject3 = ((JSONObject)localObject3).optString("itemId");
            localObject4 = blve.a((String)localObject3);
            if (localObject4 != null) {
              ((blsx)localObject1).d((blrs)localObject4);
            } else if (QLog.isColorLevel()) {
              QLog.d("QTemplate", 2, "createTemplate musicNull " + str1 + ":" + (String)localObject3);
            }
          }
          catch (Exception localException2)
          {
            QLog.d("CaptureComboManager", 1, "createTemplateSet exception", localException2);
          }
        }
      }
      if (paramQIMTemplateItem.c != null)
      {
        j = paramQIMTemplateItem.c.length();
        i = 0;
        if (i < j)
        {
          localObject3 = paramQIMTemplateItem.c.optJSONObject(i);
          if (localObject3 == null) {
            break label1104;
          }
          try
          {
            String str2 = ((JSONObject)localObject3).optString("tagId");
            localObject3 = ((JSONObject)localObject3).optString("itemId");
            if (bdnn.a(str2)) {
              break label1104;
            }
            localObject4 = blve.b((String)localObject3);
            if (localObject4 != null) {
              ((blsx)localObject1).d((blrs)localObject4);
            } else if (QLog.isColorLevel()) {
              QLog.d("QTemplate", 2, "createTemplateSet ptvNull " + str2 + ":" + (String)localObject3);
            }
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
          }
        }
      }
      if (paramQIMTemplateItem.d != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QCombo", 2, "createCombo texts " + paramQIMTemplateItem.d + " size: " + paramQIMTemplateItem.d.length());
        }
        k = paramQIMTemplateItem.d.length();
        i = 0;
      }
    }
    for (;;)
    {
      if (i < k)
      {
        localObject3 = paramQIMTemplateItem.d.optJSONObject(i);
        if (localObject3 == null) {}
      }
      else
      {
        for (;;)
        {
          try
          {
            String str3 = ((JSONObject)localObject3).optString("text_id");
            localObject5 = ((JSONObject)localObject3).optJSONArray("texts");
            if (localObject5 == null) {
              break label1122;
            }
            localObject4 = new ArrayList();
            j = 0;
            if (j < ((JSONArray)localObject5).length())
            {
              String str4 = ((JSONArray)localObject5).getString(j);
              if (TextUtils.isEmpty(str4)) {
                break label1113;
              }
              ((List)localObject4).add(str4);
              break label1113;
            }
            f1 = Float.valueOf(((JSONObject)localObject3).optString("position_x")).floatValue();
            f2 = Float.valueOf(((JSONObject)localObject3).optString("position_y")).floatValue();
            f3 = Float.valueOf(((JSONObject)localObject3).optString("scale")).floatValue();
            if (QLog.isColorLevel()) {
              QLog.d("QCombo", 2, "create  TextCombo ID: " + str3);
            }
            localObject5 = new SegmentKeeper();
            ((SegmentKeeper)localObject5).fromJSONObject((JSONObject)localObject3);
            localObject3 = blve.a(str3, (List)localObject4, f1, f2, f3);
            if (localObject3 != null)
            {
              ((blrs)localObject3).a((SegmentKeeper)localObject5);
              ((blsx)localObject1).d((blrs)localObject3);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("QTemplate", 2, "createCombo texts Null id=" + str3);
            }
          }
          catch (Exception localException4)
          {
            localException4.printStackTrace();
          }
          this.jdField_d_of_type_JavaUtilHashMap.put(paramQIMTemplateItem.jdField_a_of_type_JavaLangString, localObject1);
          ((blsx)localObject1).jdField_a_of_type_JavaLangObject = paramQIMTemplateItem;
          return localObject1;
          label1086:
          i += 1;
          break;
          label1095:
          i += 1;
          break label437;
          label1104:
          i += 1;
          break label586;
          label1113:
          j += 1;
        }
      }
      label1122:
      i += 1;
    }
  }
  
  public blsx a(QIMTemplateItem paramQIMTemplateItem, Activity paramActivity, Bundle paramBundle)
  {
    paramQIMTemplateItem = ((blrx)blqr.a(5)).a(paramQIMTemplateItem);
    paramQIMTemplateItem.b(paramActivity, paramBundle.getInt("capture_scene", -1));
    paramQIMTemplateItem.b = new WeakReference(paramActivity);
    switch (paramQIMTemplateItem.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "applyTemplate state = " + paramQIMTemplateItem.jdField_a_of_type_Int);
      }
      return paramQIMTemplateItem;
      a(new blsc(paramQIMTemplateItem, paramBundle, paramActivity));
      paramActivity = Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 7, 0, 0, paramQIMTemplateItem);
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        a(paramActivity);
      }
      else
      {
        paramActivity.sendToTarget();
        continue;
        a(new blsc(paramQIMTemplateItem, paramBundle, paramActivity));
        continue;
        a(new blsc(paramQIMTemplateItem, paramBundle, paramActivity));
        paramQIMTemplateItem.b();
      }
    }
  }
  
  public bnhd a()
  {
    if (this.jdField_a_of_type_Bnhc != null) {
      return this.jdField_a_of_type_Bnhc.a;
    }
    return null;
  }
  
  public QIMFilterCategoryItem a(int paramInt)
  {
    String str = "combo-" + paramInt;
    Object localObject1 = this.jdField_a_of_type_Bnhc;
    if (localObject1 == null) {
      return null;
    }
    localObject1 = ((bnhc)localObject1).a;
    if (localObject1 == null) {
      return null;
    }
    localObject1 = ((bnhd)localObject1).jdField_a_of_type_JavaUtilArrayList;
    if (localObject1 != null)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem;
      do
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        Object localObject2;
        while (!((Iterator)localObject2).hasNext())
        {
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (FilterCategory)((Iterator)localObject1).next();
          } while ((localObject2 == null) || (((FilterCategory)localObject2).jdField_a_of_type_JavaUtilList == null));
          localObject2 = ((FilterCategory)localObject2).jdField_a_of_type_JavaUtilList.iterator();
        }
        localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject2).next();
      } while ((localQIMFilterCategoryItem == null) || (!str.equals(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString)));
      return localQIMFilterCategoryItem;
    }
    return null;
  }
  
  public QIMFilterCategoryItem a(Activity paramActivity, bkms parambkms, int paramInt)
  {
    parambkms = (ComboProviderView)paramActivity.findViewById(2131363941);
    if (parambkms != null)
    {
      parambkms.b();
      parambkms = blzf.a().a(parambkms.g);
      if ((parambkms != null) && (parambkms.a() != null))
      {
        parambkms.a().a();
        parambkms.a().a();
        parambkms.a().a();
      }
    }
    parambkms = (StaticStickerProviderView)paramActivity.findViewById(2131363952);
    if (parambkms != null) {
      parambkms.b();
    }
    parambkms = (QIMFilterProviderView)paramActivity.findViewById(2131363943);
    if (parambkms != null) {
      parambkms.b();
    }
    paramActivity = (MusicProviderView)paramActivity.findViewById(2131363951);
    if (paramActivity != null) {
      paramActivity.b();
    }
    return bnhb.a().a(paramInt);
  }
  
  public QIMFilterCategoryItem a(blsn paramblsn, ArrayList<QIMFilterCategoryItem> paramArrayList)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (paramblsn != null)
    {
      localObject1 = localObject3;
      if ((paramblsn.jdField_a_of_type_JavaLangObject instanceof QIMFilterCategoryItem))
      {
        localObject3 = (QIMFilterCategoryItem)paramblsn.jdField_a_of_type_JavaLangObject;
        if (!((QIMFilterCategoryItem)localObject3).jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          break label176;
        }
      }
    }
    label278:
    label280:
    label283:
    for (localObject1 = null;; localObject1 = paramblsn)
    {
      if (localObject1 == null)
      {
        localObject3 = ((QIMFilterCategoryItem)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
        paramblsn = (blsn)localObject2;
        do
        {
          localObject2 = paramblsn;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject3).next();
          localObject2 = bnhb.a().a((String)localObject2);
        } while (localObject2 == null);
        if (QQAVImageFilterConstants.getFilterType(((FilterDesc)localObject2).id) == 2)
        {
          if (localObject2 == null) {
            break label278;
          }
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            paramblsn = (QIMFilterCategoryItem)paramArrayList.next();
            if ((paramblsn.jdField_a_of_type_JavaUtilArrayList.size() == 1) && (paramblsn.jdField_a_of_type_JavaUtilArrayList.contains(((FilterDesc)localObject2).name)))
            {
              localObject1 = paramblsn;
              return localObject1;
              label176:
              Iterator localIterator1 = paramArrayList.iterator();
              paramblsn = null;
              label184:
              if (!localIterator1.hasNext()) {
                break label283;
              }
              localObject1 = (QIMFilterCategoryItem)localIterator1.next();
              if (((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaUtilArrayList.size() != ((QIMFilterCategoryItem)localObject3).jdField_a_of_type_JavaUtilArrayList.size()) {
                break label280;
              }
              Iterator localIterator2 = ((QIMFilterCategoryItem)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
              while (localIterator2.hasNext())
              {
                String str = (String)localIterator2.next();
                if (((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaUtilArrayList.contains(str)) {
                  paramblsn = (blsn)localObject1;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        break label184;
        paramblsn = (blsn)localObject2;
        break;
        return localObject1;
      }
    }
  }
  
  public QIMFilterCategoryItem a(blsx paramblsx, ArrayList<QIMFilterCategoryItem> paramArrayList)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (paramblsx != null)
    {
      localObject1 = localObject3;
      if ((paramblsx.jdField_a_of_type_JavaLangObject instanceof QIMTemplateItem))
      {
        localObject3 = (QIMTemplateItem)paramblsx.jdField_a_of_type_JavaLangObject;
        if (!((QIMTemplateItem)localObject3).jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          break label176;
        }
      }
    }
    label278:
    label280:
    label283:
    for (localObject1 = null;; localObject1 = paramblsx)
    {
      if (localObject1 == null)
      {
        localObject3 = ((QIMTemplateItem)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
        paramblsx = (blsx)localObject2;
        do
        {
          localObject2 = paramblsx;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject3).next();
          localObject2 = bnhb.a().a((String)localObject2);
        } while (localObject2 == null);
        if (QQAVImageFilterConstants.getFilterType(((FilterDesc)localObject2).id) == 2)
        {
          if (localObject2 == null) {
            break label278;
          }
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            paramblsx = (QIMFilterCategoryItem)paramArrayList.next();
            if ((paramblsx.jdField_a_of_type_JavaUtilArrayList.size() == 1) && (paramblsx.jdField_a_of_type_JavaUtilArrayList.contains(((FilterDesc)localObject2).name)))
            {
              localObject1 = paramblsx;
              return localObject1;
              label176:
              Iterator localIterator1 = paramArrayList.iterator();
              paramblsx = null;
              label184:
              if (!localIterator1.hasNext()) {
                break label283;
              }
              localObject1 = (QIMFilterCategoryItem)localIterator1.next();
              if (((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaUtilArrayList.size() != ((QIMTemplateItem)localObject3).jdField_a_of_type_JavaUtilArrayList.size()) {
                break label280;
              }
              Iterator localIterator2 = ((QIMTemplateItem)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
              while (localIterator2.hasNext())
              {
                String str = (String)localIterator2.next();
                if (((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaUtilArrayList.contains(str)) {
                  paramblsx = (blsx)localObject1;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        break label184;
        paramblsx = (blsx)localObject2;
        break;
        return localObject1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_b_of_type_Int & 0x3) == 3) {}
    do
    {
      return;
      this.jdField_b_of_type_Int |= paramInt;
    } while ((this.jdField_b_of_type_Int & 0x3) != 3);
    if (QLog.isColorLevel()) {
      QLog.i("CaptureComboManager", 2, "first random");
    }
    e();
  }
  
  public void a(int paramInt, Activity paramActivity)
  {
    Object localObject = bnhb.a().a(paramInt);
    if (localObject != null)
    {
      localObject = a((QIMFilterCategoryItem)localObject);
      if ((localObject != null) && (((blsn)localObject).jdField_a_of_type_Int == 1))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("capture_scene", paramInt);
        blsn localblsn = bnhb.a().a[paramInt];
        if (localblsn != null) {
          a((QIMFilterCategoryItem)localblsn.jdField_a_of_type_JavaLangObject, paramActivity, (Bundle)localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "stopApplyDownload scene " + paramInt);
        }
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    blsb[] arrayOfblsb = this.jdField_a_of_type_ArrayOfBlsb;
    int j = arrayOfblsb.length;
    int i = 0;
    while (i < j)
    {
      arrayOfblsb[i].c(paramActivity);
      i += 1;
    }
  }
  
  public void a(Activity paramActivity, int paramInt, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("capture_scene", paramInt);
    a(paramQIMFilterCategoryItem, paramActivity, localBundle);
  }
  
  public void a(blsa paramblsa)
  {
    synchronized (this.jdField_e_of_type_JavaUtilArrayList)
    {
      if (!this.jdField_e_of_type_JavaUtilArrayList.contains(paramblsa)) {
        this.jdField_e_of_type_JavaUtilArrayList.add(paramblsa);
      }
      return;
    }
  }
  
  public void a(blsc paramblsc)
  {
    synchronized (this.jdField_e_of_type_JavaUtilHashMap)
    {
      String str = paramblsc.jdField_a_of_type_Blsf.b();
      ArrayList localArrayList2 = (ArrayList)this.jdField_e_of_type_JavaUtilHashMap.get(str);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.jdField_e_of_type_JavaUtilHashMap.put(str, localArrayList1);
      }
      localArrayList1.add(paramblsc);
      return;
    }
  }
  
  public void a(blsf paramblsf)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "downloadComboSuccess captureSet " + paramblsf);
    }
    if ((paramblsf.jdField_a_of_type_JavaLangObject instanceof QIMFilterCategoryItem)) {}
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      this.jdField_d_of_type_JavaUtilArrayList.add((QIMFilterCategoryItem)paramblsf.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 7, 0, 0, paramblsf).sendToTarget();
      return;
    }
  }
  
  public void a(blsf paramblsf, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "downloadComboFailed captureset " + paramblsf);
    }
    if ((paramblsf.jdField_a_of_type_JavaLangObject instanceof QIMFilterCategoryItem)) {}
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      this.jdField_d_of_type_JavaUtilArrayList.add((QIMFilterCategoryItem)paramblsf.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 7, paramInt, 0, paramblsf).sendToTarget();
      return;
    }
  }
  
  public void a(blsn paramblsn)
  {
    Iterator localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((blsa)localIterator.next()).a(paramblsn);
    }
  }
  
  public void a(blsx paramblsx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "downloadTemplateSuccess templateSet " + paramblsx);
    }
    if ((paramblsx.jdField_a_of_type_JavaLangObject instanceof QIMTemplateItem)) {}
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add((QIMTemplateItem)paramblsx.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 7, 0, 0, paramblsx).sendToTarget();
      return;
    }
  }
  
  public void a(blsx paramblsx, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "downloadTemplateFailed templateSet " + paramblsx + ", error " + paramInt);
    }
    if ((paramblsx.jdField_a_of_type_JavaLangObject instanceof QIMTemplateItem)) {}
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add((QIMTemplateItem)paramblsx.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 7, paramInt, 0, paramblsx).sendToTarget();
      return;
    }
  }
  
  public void a(bnhc parambnhc)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("updateData data is null?");
      if (parambnhc != null) {
        break label76;
      }
    }
    label76:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QCombo", 2, bool);
      if (parambnhc != null)
      {
        this.jdField_a_of_type_Bnhc = parambnhc;
        this.jdField_a_of_type_Blsj.a(parambnhc);
        Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 9, parambnhc).sendToTarget();
      }
      a(1);
      return;
    }
  }
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pre_capture_combo_select", 0);
    String str = "";
    if ((paramQIMFilterCategoryItem.e()) || (paramQIMFilterCategoryItem.c())) {
      str = paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString;
    }
    paramQIMFilterCategoryItem = str;
    if (str == null) {
      paramQIMFilterCategoryItem = "";
    }
    localSharedPreferences.edit().putString("select", paramQIMFilterCategoryItem).apply();
  }
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem, Activity paramActivity, Bundle paramBundle)
  {
    int i = paramBundle.getInt("capture_scene", -1);
    QIMFilterCategoryItem localQIMFilterCategoryItem = bnhb.a().b(i);
    boolean bool1;
    boolean bool2;
    if ((localQIMFilterCategoryItem != null) && (TextUtils.equals(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString)))
    {
      bool1 = true;
      if ((localQIMFilterCategoryItem != null) || (!a(paramQIMFilterCategoryItem))) {
        break label165;
      }
      bool2 = true;
      label58:
      boolean bool3 = paramBundle.getBoolean("capture_force_enable", false);
      if (((!bool1) && (!bool2)) || (bool3)) {
        break label171;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CaptureComboManager", 2, new Object[] { "applyFilters repeat, sameItem: ", Boolean.valueOf(bool1), " emptyItem:", Boolean.valueOf(bool2), " filterItem:", paramQIMFilterCategoryItem.jdField_b_of_type_JavaLangString, " isForceEnable:", Boolean.valueOf(bool3) });
      }
    }
    for (;;)
    {
      return;
      bool1 = false;
      break;
      label165:
      bool2 = false;
      break label58;
      label171:
      paramQIMFilterCategoryItem = ((blrx)blqr.a(5)).a(paramQIMFilterCategoryItem);
      paramQIMFilterCategoryItem.b(paramActivity, i);
      paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      switch (paramQIMFilterCategoryItem.jdField_a_of_type_Int)
      {
      }
      while (QLog.isColorLevel())
      {
        QLog.i("QCombo", 2, "applyFilters state = " + paramQIMFilterCategoryItem.jdField_a_of_type_Int);
        return;
        a(new blsc(paramQIMFilterCategoryItem, paramBundle, paramActivity));
        paramActivity = Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 7, 0, 0, paramQIMFilterCategoryItem);
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          a(paramActivity);
        }
        else
        {
          paramActivity.sendToTarget();
          continue;
          a(new blsc(paramQIMFilterCategoryItem, paramBundle, paramActivity));
          continue;
          a(new blsc(paramQIMFilterCategoryItem, paramBundle, paramActivity));
          bmaz.a(paramQIMFilterCategoryItem).a();
          paramQIMFilterCategoryItem.b();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureComboManager", 2, "yes to do setBeRecording" + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    for (;;)
    {
      boolean bool;
      int i;
      synchronized (this.jdField_d_of_type_JavaUtilArrayList)
      {
        this.jdField_c_of_type_JavaUtilArrayList.addAll(this.jdField_d_of_type_JavaUtilArrayList);
        this.jdField_d_of_type_JavaUtilArrayList.clear();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "syncStateAndProgress " + this.jdField_c_of_type_JavaUtilArrayList.size());
        }
        bool = false;
        i = this.jdField_c_of_type_JavaUtilArrayList.size() - 1;
        if (i < 0) {
          break label470;
        }
        QIMFilterCategoryItem localQIMFilterCategoryItem1 = (QIMFilterCategoryItem)this.jdField_c_of_type_JavaUtilArrayList.get(i);
        ??? = a(localQIMFilterCategoryItem1);
        if (((blsf)???).jdField_a_of_type_Int == 1)
        {
          int j = ((blsf)???).a();
          if (j != ((blsf)???).jdField_a_of_type_Int)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QCombo", 2, "buildComboBatch progress: " + localQIMFilterCategoryItem1.jdField_b_of_type_JavaLangString + ", progress: " + ((blsf)???).jdField_b_of_type_Int);
            }
            ((blsf)???).jdField_a_of_type_Int = j;
          }
          j = (int)(10000.0F * ((blsf)???).a());
          if (j != ((blsf)???).jdField_b_of_type_Int)
          {
            ((blsf)???).jdField_b_of_type_Int = j;
            if (QLog.isColorLevel()) {
              QLog.i("QCombo", 2, "buildComboBatch progress: " + j + ", progress: " + ((blsf)???).jdField_b_of_type_Int);
            }
          }
          bool = true;
          i -= 1;
        }
      }
      QIMFilterCategoryItem localQIMFilterCategoryItem2;
      if (((blsf)???).jdField_a_of_type_Int == 2)
      {
        ((blsf)???).a();
        localQIMFilterCategoryItem2 = (QIMFilterCategoryItem)this.jdField_c_of_type_JavaUtilArrayList.remove(i);
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "removeComboBatch: " + localQIMFilterCategoryItem2.jdField_b_of_type_JavaLangString + ",  STATE_NEED_DOWNLOAD progress: " + ((blsf)???).jdField_b_of_type_Int);
        }
        bool = true;
      }
      else if (((blsf)???).jdField_a_of_type_Int == 3)
      {
        ((blsf)???).a();
        ((blsf)???).jdField_b_of_type_Int = 10000;
        localQIMFilterCategoryItem2 = (QIMFilterCategoryItem)this.jdField_c_of_type_JavaUtilArrayList.remove(i);
        bmaz.a(???).b();
        Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 2, ???).sendToTarget();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "removeComboBatch: " + localQIMFilterCategoryItem2.jdField_b_of_type_JavaLangString + ", STATE_DOWNLOADED progress: " + ((blsf)???).jdField_b_of_type_Int);
        }
        bool = true;
        continue;
        label470:
        return bool;
      }
    }
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      int i = paramMessage.arg1;
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "MSG_APPLY error " + i + " " + paramMessage.obj);
      }
      Object localObject1;
      Object localObject2;
      Object localObject3;
      label405:
      label411:
      int j;
      if ((paramMessage.obj instanceof blsq))
      {
        paramMessage = (blsq)paramMessage.obj;
        if (i == 0)
        {
          bmaz.a(paramMessage).b();
          localObject1 = paramMessage.b();
          localObject1 = (ArrayList)this.jdField_e_of_type_JavaUtilHashMap.get(localObject1);
          if (localObject1 == null) {
            continue;
          }
          localObject2 = (ArrayList)((ArrayList)localObject1).clone();
          ((ArrayList)localObject1).clear();
          localObject1 = (QIMFilterCategoryItem)paramMessage.jdField_a_of_type_JavaLangObject;
          if (i == 0) {
            localObject2 = ((ArrayList)localObject2).iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label411;
            }
            localObject3 = (blsc)((Iterator)localObject2).next();
            i = ((blsc)localObject3).jdField_a_of_type_AndroidOsBundle.getInt("capture_scene", -1);
            ??? = bnhb.a().b(i);
            if ((localObject1 != null) && (??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString, ((QIMFilterCategoryItem)???).jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Boolean))
            {
              if (QLog.isColorLevel()) {
                QLog.d("QCombo", 2, "MSG_APPLY filter " + i + " " + ???);
              }
              ((bknb)blqr.a(13)).a(((QIMFilterCategoryItem)???).jdField_a_of_type_JavaLangString);
              ??? = (Activity)((blsc)localObject3).jdField_a_of_type_JavaLangRefWeakReference.get();
              if (??? != null)
              {
                paramMessage.a((Activity)???, i);
                synchronized (this.jdField_e_of_type_JavaUtilArrayList)
                {
                  ??? = this.jdField_e_of_type_JavaUtilArrayList.iterator();
                  if (!((Iterator)???).hasNext()) {
                    break label405;
                  }
                  ((blsa)((Iterator)???).next()).a(paramMessage, true, 0, ((blsc)localObject3).jdField_a_of_type_AndroidOsBundle);
                }
                bmaz.a(paramMessage).c();
                break;
              }
            }
          }
          this.jdField_a_of_type_Blsq = paramMessage;
          continue;
        }
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (blsc)((Iterator)localObject2).next();
          j = ((blsc)localObject3).jdField_a_of_type_AndroidOsBundle.getInt("capture_scene", -1);
          ??? = bnhb.a().b(j);
          if ((localObject1 != null) && (??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString, ((QIMFilterCategoryItem)???).jdField_a_of_type_JavaLangString)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QCombo", 2, "MSG_APPLY filter " + j + " " + ???);
            }
            ((bknb)blqr.a(13)).a(((QIMFilterCategoryItem)???).jdField_a_of_type_JavaLangString);
            if ((Activity)((blsc)localObject3).jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
              synchronized (this.jdField_e_of_type_JavaUtilArrayList)
              {
                ??? = this.jdField_e_of_type_JavaUtilArrayList.iterator();
                if (((Iterator)???).hasNext()) {
                  ((blsa)((Iterator)???).next()).a(paramMessage, false, i, ((blsc)localObject3).jdField_a_of_type_AndroidOsBundle);
                }
              }
            }
            QQToast.a(BaseApplicationImpl.sApplication, alud.a(2131701739), 0).a();
          }
        }
      }
      else if ((paramMessage.obj instanceof blsn))
      {
        paramMessage = (blsn)paramMessage.obj;
        if (i == 0)
        {
          bmaz.a(paramMessage).b();
          localObject1 = (QIMFilterCategoryItem)paramMessage.jdField_a_of_type_JavaLangObject;
          localObject2 = paramMessage.b();
          localObject2 = (ArrayList)this.jdField_e_of_type_JavaUtilHashMap.get(localObject2);
          if (localObject2 == null) {
            continue;
          }
          localObject3 = (ArrayList)((ArrayList)localObject2).clone();
          ((ArrayList)localObject2).clear();
          if (i == 0) {
            localObject2 = ((ArrayList)localObject3).iterator();
          }
        }
        else
        {
          label976:
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label982;
            }
            localObject3 = (blsc)((Iterator)localObject2).next();
            ??? = (Activity)((blsc)localObject3).jdField_a_of_type_JavaLangRefWeakReference.get();
            if (??? != null)
            {
              i = ((blsc)localObject3).jdField_a_of_type_AndroidOsBundle.getInt("capture_scene", -1);
              ??? = bnhb.a().a(i);
              if ((??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)???).jdField_a_of_type_JavaLangString, ((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString)))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QCombo", 2, "MSG_APPLY success " + i + " " + localObject1);
                }
                ((bknb)blqr.a(13)).b(((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString);
                b((Activity)???, i);
                if (!blru.a(paramMessage, i)) {
                  paramMessage.a((Activity)???, i);
                }
                synchronized (this.jdField_e_of_type_JavaUtilArrayList)
                {
                  ??? = this.jdField_e_of_type_JavaUtilArrayList.iterator();
                  if (!((Iterator)???).hasNext()) {
                    break label976;
                  }
                  ((blsa)((Iterator)???).next()).a(paramMessage, true, 0, ((blsc)localObject3).jdField_a_of_type_AndroidOsBundle);
                }
                bmaz.a(paramMessage).c();
                break;
              }
            }
          }
          label982:
          this.jdField_a_of_type_Blsn = paramMessage;
          continue;
        }
        localObject2 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (blsc)((Iterator)localObject2).next();
          j = ((blsc)localObject3).jdField_a_of_type_AndroidOsBundle.getInt("capture_scene", -1);
          ??? = bnhb.a().a(j);
          if ((??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)???).jdField_a_of_type_JavaLangString, ((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QCombo", 2, "MSG_APPLY fail " + j + " " + localObject1);
            }
            ((bknb)blqr.a(13)).b(((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString);
            ??? = (Activity)((blsc)localObject3).jdField_a_of_type_JavaLangRefWeakReference.get();
            if (??? != null)
            {
              synchronized (this.jdField_e_of_type_JavaUtilArrayList)
              {
                ??? = this.jdField_e_of_type_JavaUtilArrayList.iterator();
                if (((Iterator)???).hasNext()) {
                  ((blsa)((Iterator)???).next()).a(paramMessage, false, i, ((blsc)localObject3).jdField_a_of_type_AndroidOsBundle);
                }
              }
              ??? = (blrx)blqr.a(5);
              ??? = ((blrx)???).jdField_a_of_type_Blsn;
              if (??? != null) {
                ((blrx)???).a((QIMFilterCategoryItem)((blsn)???).jdField_a_of_type_JavaLangObject, (Activity)???, ((blsc)localObject3).jdField_a_of_type_AndroidOsBundle);
              }
            }
            QQToast.a(BaseApplicationImpl.sApplication, alud.a(2131701741), 0).a();
          }
        }
      }
      else if ((paramMessage.obj instanceof blsx))
      {
        localObject1 = (blsg)blqr.a(15);
        paramMessage = (blsx)paramMessage.obj;
        if (i == 0)
        {
          bmaz.a(paramMessage).b();
          localObject2 = (QIMTemplateItem)paramMessage.jdField_a_of_type_JavaLangObject;
          localObject3 = paramMessage.b();
          localObject3 = (ArrayList)this.jdField_e_of_type_JavaUtilHashMap.get(localObject3);
          if (localObject3 == null) {
            continue;
          }
          ??? = (ArrayList)((ArrayList)localObject3).clone();
          ((ArrayList)localObject3).clear();
          if (i == 0) {
            localObject3 = ((ArrayList)???).iterator();
          }
        }
        else
        {
          label1584:
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label1590;
            }
            ??? = (blsc)((Iterator)localObject3).next();
            ??? = (Activity)((blsc)???).jdField_a_of_type_JavaLangRefWeakReference.get();
            if (??? != null)
            {
              i = ((blsc)???).jdField_a_of_type_AndroidOsBundle.getInt("capture_scene", -1);
              ??? = ((blsg)localObject1).a(i);
              if ((??? != null) && (TextUtils.equals(((QIMTemplateItem)???).jdField_a_of_type_JavaLangString, ((QIMTemplateItem)localObject2).jdField_a_of_type_JavaLangString)))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QTemplate", 2, "MSG_APPLY template success:" + i + ", item:" + localObject2);
                }
                a((Activity)???, i);
                if (!((blsg)localObject1).a(paramMessage, i)) {
                  paramMessage.a((Activity)???, i);
                }
                synchronized (this.jdField_e_of_type_JavaUtilArrayList)
                {
                  ??? = this.jdField_e_of_type_JavaUtilArrayList.iterator();
                  if (!((Iterator)???).hasNext()) {
                    break label1584;
                  }
                  ((blsa)((Iterator)???).next()).a(paramMessage, true, 0, ((blsc)???).jdField_a_of_type_AndroidOsBundle);
                }
                bmaz.a(paramMessage).c();
                break;
              }
            }
          }
          label1590:
          ((blsg)localObject1).a(paramMessage);
          continue;
        }
        localObject3 = ((ArrayList)???).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ??? = (blsc)((Iterator)localObject3).next();
          j = ((blsc)???).jdField_a_of_type_AndroidOsBundle.getInt("capture_scene", -1);
          ??? = ((blsg)localObject1).a(j);
          if ((??? != null) && (TextUtils.equals(((QIMTemplateItem)???).jdField_a_of_type_JavaLangString, ((QIMTemplateItem)localObject2).jdField_a_of_type_JavaLangString)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QTemplate", 2, "MSG_APPLY template fail " + j + " " + localObject2);
            }
            ??? = (Activity)((blsc)???).jdField_a_of_type_JavaLangRefWeakReference.get();
            if (??? != null)
            {
              synchronized (this.jdField_e_of_type_JavaUtilArrayList)
              {
                localObject7 = this.jdField_e_of_type_JavaUtilArrayList.iterator();
                if (((Iterator)localObject7).hasNext()) {
                  ((blsa)((Iterator)localObject7).next()).a(paramMessage, false, i, ((blsc)???).jdField_a_of_type_AndroidOsBundle);
                }
              }
              ??? = ((blsg)localObject1).a();
              Object localObject7 = (blrx)blqr.a(5);
              if (??? != null) {
                ((blrx)localObject7).a((QIMTemplateItem)((blsx)???).jdField_a_of_type_JavaLangObject, (Activity)???, ((blsc)???).jdField_a_of_type_AndroidOsBundle);
              }
            }
            QQToast.a(BaseApplicationImpl.sApplication, alud.a(2131701740), 0).a();
          }
        }
        paramMessage = (bnhc)paramMessage.obj;
        try
        {
          localObject1 = this.jdField_e_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((blsa)((Iterator)localObject1).next()).a(paramMessage);
          }
        }
        finally {}
      }
    }
  }
  
  public boolean a(List<FilterCategory> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "preInitCombo: " + paramList.size());
    }
    Iterator localIterator1 = paramList.iterator();
    boolean bool = false;
    FilterCategory localFilterCategory;
    Iterator localIterator2;
    if (localIterator1.hasNext())
    {
      localFilterCategory = (FilterCategory)localIterator1.next();
      localIterator2 = localFilterCategory.jdField_a_of_type_JavaUtilList.iterator();
    }
    for (;;)
    {
      if (localIterator2.hasNext())
      {
        QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)localIterator2.next();
        if (localFilterCategory.jdField_a_of_type_Boolean) {}
        for (paramList = a(localQIMFilterCategoryItem);; paramList = a(localQIMFilterCategoryItem))
        {
          paramList.jdField_a_of_type_Int = paramList.a();
          if (paramList.jdField_a_of_type_Int != 1) {
            break label208;
          }
          paramList.jdField_b_of_type_Int = ((int)(10000.0F * paramList.a()));
          if (!QLog.isColorLevel()) {
            break label239;
          }
          QLog.d("QCombo", 2, "preInitCombo progress: " + localQIMFilterCategoryItem.jdField_b_of_type_JavaLangString + ", progress: " + paramList.jdField_b_of_type_Int);
          bool = true;
          break;
        }
        label208:
        if ((paramList.jdField_a_of_type_Int != 2) && (paramList.jdField_a_of_type_Int == 3)) {
          paramList.jdField_b_of_type_Int = 10000;
        }
      }
      else
      {
        break;
        return bool;
        label239:
        bool = true;
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Blsj.a();
  }
  
  public void b(blsa paramblsa)
  {
    synchronized (this.jdField_e_of_type_JavaUtilArrayList)
    {
      this.jdField_e_of_type_JavaUtilArrayList.remove(paramblsa);
      return;
    }
  }
  
  public void b(blsf paramblsf)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "notifyDownloadBegin combo " + paramblsf);
    }
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      this.jdField_d_of_type_JavaUtilArrayList.add((QIMFilterCategoryItem)paramblsf.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
  }
  
  public void b(blsx paramblsx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "notifyDownloadTemplateBegin templateSet " + paramblsx);
    }
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add((QIMTemplateItem)paramblsx.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
  }
  
  public boolean b()
  {
    for (;;)
    {
      boolean bool;
      int i;
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "syncStateAndProgress " + this.jdField_a_of_type_JavaUtilArrayList.size());
        }
        bool = false;
        i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i < 0) {
          break label458;
        }
        QIMTemplateItem localQIMTemplateItem1 = (QIMTemplateItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        ??? = a(localQIMTemplateItem1);
        if (((blsf)???).jdField_a_of_type_Int == 1)
        {
          int j = ((blsf)???).a();
          if (j != ((blsf)???).jdField_a_of_type_Int)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QCombo", 2, "buildComboBatch progress: " + localQIMTemplateItem1.jdField_b_of_type_JavaLangString + ", progress: " + ((blsf)???).jdField_b_of_type_Int);
            }
            ((blsf)???).jdField_a_of_type_Int = j;
          }
          j = (int)(10000.0F * ((blsf)???).a());
          if (j != ((blsf)???).jdField_b_of_type_Int)
          {
            ((blsf)???).jdField_b_of_type_Int = j;
            if (QLog.isColorLevel()) {
              QLog.i("QCombo", 2, "buildComboBatch progress: " + j + ", progress: " + ((blsf)???).jdField_b_of_type_Int);
            }
          }
          bool = true;
          i -= 1;
        }
      }
      QIMTemplateItem localQIMTemplateItem2;
      if (((blsf)???).jdField_a_of_type_Int == 2)
      {
        localQIMTemplateItem2 = (QIMTemplateItem)this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "removeComboBatch: " + localQIMTemplateItem2.jdField_b_of_type_JavaLangString + ",  STATE_NEED_DOWNLOAD progress: " + ((blsf)???).jdField_b_of_type_Int);
        }
        bool = true;
      }
      else if (((blsf)???).jdField_a_of_type_Int == 3)
      {
        ((blsf)???).jdField_b_of_type_Int = 10000;
        localQIMTemplateItem2 = (QIMTemplateItem)this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        bmaz.a(???).b();
        Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 2, ???).sendToTarget();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "removeComboBatch: " + localQIMTemplateItem2.jdField_b_of_type_JavaLangString + ", STATE_DOWNLOADED progress: " + ((blsf)???).jdField_b_of_type_Int);
        }
        bool = true;
        continue;
        label458:
        return bool;
      }
    }
  }
  
  public void c()
  {
    bnhb.a().a(BaseApplicationImpl.getContext(), null, false);
    if (QLog.isDevelopLevel()) {
      QLog.d("CaptureComboManager", 4, "initComboConfig");
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Uul.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Uul.b);
  }
  
  public void d()
  {
    if ((this.jdField_d_of_type_JavaUtilHashMap != null) && (this.jdField_d_of_type_JavaUtilHashMap.size() > 0)) {
      this.jdField_d_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void e()
  {
    bnhc localbnhc = this.jdField_a_of_type_Bnhc;
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "randomliseData " + localbnhc);
    }
    if (localbnhc != null)
    {
      localbnhc.a();
      a(localbnhc);
    }
  }
  
  public void f()
  {
    a().notifyObservers(blsd.class, 971, true, null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return a(paramMessage);
  }
  
  public boolean isValidate()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrx
 * JD-Core Version:    0.7.0.1
 */