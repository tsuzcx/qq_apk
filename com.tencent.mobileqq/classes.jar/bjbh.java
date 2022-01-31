import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilter;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilterInfo;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.richmedia.capture.data.FilterDesc;>;

public class bjbh
  extends bjbf
{
  public float a;
  bjbj a;
  public FilterDesc a;
  
  public bjbh(FilterDesc paramFilterDesc)
  {
    super(paramFilterDesc);
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_a_of_type_Bjbj = new bjbj(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = paramFilterDesc;
  }
  
  public static int a(Context paramContext, List<FilterDesc> paramList, bjbs parambjbs, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramInt == 0) {
      a(paramContext, paramList);
    }
    do
    {
      return 0;
      if ((paramInt == 2) || (paramInt == 4))
      {
        if (paramInt == 2) {}
        for (;;)
        {
          c(paramList, bool1);
          return 0;
          bool1 = false;
        }
      }
    } while ((paramInt != 1) && (paramInt != 3));
    if (paramInt == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      b(paramList, bool1);
      return 0;
    }
  }
  
  public static void a(Context paramContext, List<FilterDesc> paramList)
  {
    bkqo localbkqo = bkqo.a();
    QQFilterRenderManager localQQFilterRenderManager = biho.a(biho.b);
    if ((localQQFilterRenderManager == null) && (bijo.a() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "applyFiltersForCapture QQFilterRenderManager null");
      }
      return;
    }
    paramContext = new ArrayList();
    paramList = paramList.iterator();
    label53:
    FilterDesc localFilterDesc;
    if (paramList.hasNext())
    {
      localFilterDesc = (FilterDesc)paramList.next();
      if (localFilterDesc.name.equals("EMPTY"))
      {
        if (bijo.a() == null) {
          break label344;
        }
        bijo.a().a(null);
        paramContext = null;
      }
    }
    for (;;)
    {
      label101:
      int i;
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder().append("applyFiltersForCapture filters:");
        if (paramContext == null)
        {
          i = 0;
          label126:
          QLog.d("QCombo", 2, i);
        }
      }
      else
      {
        localbkqo.a(null);
        if (localQQFilterRenderManager != null) {
          localQQFilterRenderManager.getBusinessOperation().setFilterEffectList(paramContext);
        }
        if ((bijo.a() == null) || (paramContext == null) || (paramContext.size() <= 0)) {
          break;
        }
        paramList = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
        paramContext = (FilterDesc)paramContext.get(0);
        if (TextUtils.isEmpty(paramContext.resRootPath)) {
          break label335;
        }
      }
      label335:
      for (paramContext = paramContext.getResFold(paramContext.resRootPath);; paramContext = paramContext.getResFold(paramList))
      {
        paramList = QQPtColorFilter.getColorFilterInfo(paramContext);
        if (paramList == null) {
          break;
        }
        paramContext = paramContext + paramList.getColorPng();
        if (!new File(paramContext).exists()) {
          break;
        }
        bijo.a().c(false);
        bijo.a().a(paramContext);
        return;
        if (localFilterDesc.id == 9)
        {
          paramContext.clear();
          paramContext.add(localFilterDesc);
          break label101;
        }
        paramContext.add(localFilterDesc);
        break label53;
        i = paramContext.size();
        break label126;
      }
      label344:
      paramContext = null;
    }
  }
  
  public static void a(List<FilterDesc> paramList, boolean paramBoolean)
  {
    bkqo localbkqo = bkqo.a();
    QQFilterRenderManager localQQFilterRenderManager = biho.a(biho.b);
    if (localQQFilterRenderManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "applyFiltersForCapture QQFilterRenderManager null");
      }
      return;
    }
    Object localObject = new ArrayList();
    paramList = paramList.iterator();
    FilterDesc localFilterDesc;
    if (paramList.hasNext())
    {
      localFilterDesc = (FilterDesc)paramList.next();
      if (localFilterDesc.name.equals("EMPTY")) {
        paramList = null;
      }
    }
    for (;;)
    {
      label83:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("applyFiltersForCapture filters:");
        if (paramList != null) {
          break label181;
        }
      }
      label181:
      for (int i = 0;; i = paramList.size())
      {
        QLog.d("QCombo", 2, i);
        localbkqo.a(null);
        localQQFilterRenderManager.getBusinessOperation().setFilterEffectList(paramList, paramBoolean);
        return;
        if (localFilterDesc.id == 9)
        {
          ((List)localObject).clear();
          ((List)localObject).add(localFilterDesc);
          paramList = (List<FilterDesc>)localObject;
          break label83;
        }
        ((List)localObject).add(localFilterDesc);
        break;
      }
      paramList = (List<FilterDesc>)localObject;
    }
  }
  
  public static boolean a(bjbz parambjbz, int paramInt)
  {
    if (parambjbz != null)
    {
      bjbz localbjbz = bkqo.a().a[paramInt];
      if ((parambjbz != null) && (localbjbz != null) && (parambjbz.b().equals(localbjbz.b()))) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QCombo", 2, new Object[] { "isApplying :" + parambjbz + " ", Boolean.valueOf(bool) });
        }
        return bool;
      }
    }
    return false;
  }
  
  public static void b(List<FilterDesc> paramList, boolean paramBoolean)
  {
    boolean bool2 = true;
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    FilterDesc localFilterDesc;
    boolean bool1;
    if (paramList.hasNext())
    {
      localFilterDesc = (FilterDesc)paramList.next();
      if (localFilterDesc.name.equals("EMPTY"))
      {
        localArrayList.clear();
        bool1 = false;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "applyFiltersForEditPic filters:" + localArrayList.size());
      }
      new bjbi(bool2, bool1, localArrayList, paramBoolean).execute(new Void[0]);
      return;
      if (localFilterDesc.id == 9)
      {
        localArrayList.clear();
        localArrayList.add(localFilterDesc);
        bool1 = true;
        bool2 = false;
      }
      else
      {
        localArrayList.add(localFilterDesc);
        break;
        bool1 = false;
        bool2 = false;
      }
    }
  }
  
  public static void c(List<FilterDesc> paramList, boolean paramBoolean)
  {
    bkqo localbkqo = bkqo.a();
    QQFilterRenderManager localQQFilterRenderManager = biho.a(biho.c);
    if (localQQFilterRenderManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "applyFiltersForEditVideo null manager");
      }
      return;
    }
    Object localObject = new ArrayList();
    paramList = paramList.iterator();
    FilterDesc localFilterDesc;
    if (paramList.hasNext())
    {
      localFilterDesc = (FilterDesc)paramList.next();
      if (localFilterDesc.name.equals("EMPTY")) {
        paramList = null;
      }
    }
    for (;;)
    {
      label84:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("applyFiltersForEditVideo filters:");
        if (paramList != null) {
          break label182;
        }
      }
      label182:
      for (int i = 0;; i = paramList.size())
      {
        QLog.d("QCombo", 2, i);
        localQQFilterRenderManager.getBusinessOperation().setFilterEffectList(paramList);
        localbkqo.a(null);
        return;
        if (localFilterDesc.id == 9)
        {
          ((List)localObject).clear();
          ((List)localObject).add(localFilterDesc);
          paramList = (List<FilterDesc>)localObject;
          break label84;
        }
        ((List)localObject).add(localFilterDesc);
        break;
      }
      paramList = (List<FilterDesc>)localObject;
    }
  }
  
  public float a()
  {
    return 0.5F;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Float == 1.0F)
    {
      b(3);
      return 3;
    }
    if (this.jdField_a_of_type_Float >= 0.0F)
    {
      b(1);
      return 1;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.getResFold(bkue.b);
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.resurl)) && (!TextUtils.isEmpty(str)) && (bkqk.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc)))
    {
      b(2);
      return 2;
    }
    b(3);
    return 3;
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc == null) {}
    return 0;
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (paramInt == 0)
    {
      paramActivity = new ArrayList();
      paramActivity.add(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc);
      a(paramActivity, false);
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "download: " + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.predownload + ", iconurl: " + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.iconurl + ", resurl:" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.resurl);
    }
    bkqk.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc, this.jdField_a_of_type_Bjbj);
    a();
    return super.b();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String toString()
  {
    return "Filter@" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.name + "@" + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjbh
 * JD-Core Version:    0.7.0.1
 */