import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.capture.view.PtvTemplateItemView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ausc
  extends BaseAdapter
  implements awhd
{
  float jdField_a_of_type_Float;
  public int a;
  Context jdField_a_of_type_AndroidContentContext;
  private ausf jdField_a_of_type_Ausf = new ausd(this);
  ausk jdField_a_of_type_Ausk;
  private autg jdField_a_of_type_Autg;
  private auwc jdField_a_of_type_Auwc;
  private awdz jdField_a_of_type_Awdz = new ause(this);
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public PtvTemplateManager.PtvTemplateInfo a;
  public GridView a;
  public String a;
  public ArrayList<PtvTemplateManager.PtvTemplateInfo> a;
  boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  
  public ausc(AppInterface paramAppInterface, Context paramContext, GridView paramGridView, auwc paramauwc, autg paramautg, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_a_of_type_Ausk = ausk.a();
    this.jdField_a_of_type_Auwc = paramauwc;
    this.jdField_a_of_type_Autg = paramautg;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void b(int paramInt)
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo1 = ausk.a().a();
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo2 = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((localPtvTemplateInfo2 != null) && (localPtvTemplateInfo1 != null) && (localPtvTemplateInfo1.id.equals(localPtvTemplateInfo2.id)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager", 2, "checkChooseFilter  name=" + localPtvTemplateInfo1.name);
      }
      if ((localPtvTemplateInfo1.usable) || (!localPtvTemplateInfo1.downloading)) {
        a(paramInt);
      }
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public PtvTemplateManager.PtvTemplateInfo a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    return (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = null;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {}
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      return;
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    } while (localPtvTemplateInfo == null);
    this.jdField_b_of_type_Int = paramInt;
    ausk.a().a(localPtvTemplateInfo);
    if (!localPtvTemplateInfo.id.equals("0"))
    {
      ausk localausk = ausk.a();
      localausk.a(localPtvTemplateInfo, 111);
      localausk.a(3, localPtvTemplateInfo.categoryId, localPtvTemplateInfo.id);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = localPtvTemplateInfo;
    ausk.a().a(114, this.jdField_a_of_type_Autg);
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id.equals("0")))
    {
      a();
      if (this.jdField_a_of_type_Auwc != null) {
        this.jdField_a_of_type_Auwc.a(localPtvTemplateInfo, this.jdField_a_of_type_JavaLangString);
      }
      ausk.a().a(null);
      ausk.a().a(113, null);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable)
    {
      this.jdField_a_of_type_JavaLangString = ausk.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.md5);
      if (this.jdField_a_of_type_Auwc != null) {
        this.jdField_a_of_type_Auwc.a(localPtvTemplateInfo, this.jdField_a_of_type_JavaLangString);
      }
      ausk.a().a(113, null);
    }
    for (;;)
    {
      baig.a();
      return;
      if ((!this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) && (this.jdField_a_of_type_Ausk != null))
      {
        this.jdField_a_of_type_Ausk.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, this.jdField_a_of_type_Awdz);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading = true;
        ahke.a("shortvideo_download_effects", null);
      }
    }
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 111)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length == 1))
      {
        a(((autg)paramVarArgs[0]).a, 1);
        notifyDataSetChanged();
      }
      return;
      break label66;
    }
    label66:
    do
    {
      for (;;)
      {
        if (paramInt == 112) {
          if ((paramVarArgs != null) && (paramVarArgs.length == 1))
          {
            paramObject = (PtvTemplateManager.PtvTemplateInfo)paramVarArgs[0];
            paramVarArgs = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            if (paramVarArgs.hasNext())
            {
              PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramVarArgs.next();
              if (!paramObject.id.equals(localPtvTemplateInfo.id)) {
                break;
              }
              localPtvTemplateInfo.downloading = false;
              localPtvTemplateInfo.usable = true;
              notifyDataSetChanged();
              return;
            }
          }
        }
      }
    } while (paramInt != 113);
    notifyDataSetChanged();
  }
  
  public void a(List<PtvTemplateManager.PtvTemplateInfo> paramList, int paramInt)
  {
    int i = 0;
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_Int = paramInt;
      paramInt = i;
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
      while (paramInt < this.jdField_a_of_type_Int)
      {
        localPtvTemplateInfo = new PtvTemplateManager.PtvTemplateInfo();
        localPtvTemplateInfo.id = "0";
        localPtvTemplateInfo.categoryId = 0;
        this.jdField_a_of_type_JavaUtilArrayList.add(localPtvTemplateInfo);
        paramInt += 1;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramList.next();
        if ((this.jdField_a_of_type_Boolean) || (!localPtvTemplateInfo.advertisement)) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localPtvTemplateInfo);
        }
      }
      notifyDataSetChanged();
    }
    finally {}
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (!(paramView instanceof PtvTemplateItemView)))
    {
      paramView = new PtvTemplateItemView(this.jdField_a_of_type_AndroidContentContext);
      paramView.a();
    }
    for (;;)
    {
      paramView.a(paramInt, (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_a_of_type_Ausf);
      if (!this.jdField_b_of_type_Boolean) {
        b(paramInt);
      }
      return paramView;
      paramView = (PtvTemplateItemView)paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ausc
 * JD-Core Version:    0.7.0.1
 */