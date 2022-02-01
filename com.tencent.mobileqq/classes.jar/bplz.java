import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.3;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.6;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bplz
  extends BaseAdapter
  implements bczs
{
  public static String a;
  public static boolean a;
  public static int b;
  public static String b;
  public static boolean b;
  public static int c;
  public static boolean c;
  float jdField_a_of_type_Float;
  public int a;
  public Context a;
  private bhpc jdField_a_of_type_Bhpc;
  public bpme a;
  private bpvt jdField_a_of_type_Bpvt;
  private brhk jdField_a_of_type_Brhk = new bpmb(this);
  public brhn a;
  public GridView a;
  public PtvTemplateManager.PtvTemplateInfo a;
  public ArrayList<PtvTemplateManager.PtvTemplateInfo> a;
  public PtvTemplateManager.PtvTemplateInfo b;
  public int d;
  private int e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "0";
  }
  
  public bplz(Context paramContext, GridView paramGridView, bpvt parambpvt, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Bpme = new bpma(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_a_of_type_Brhn = ((brhn)bplq.a(3));
    this.jdField_a_of_type_Bpvt = parambpvt;
    this.d = paramInt;
  }
  
  public int a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!((PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).id.equals(paramPtvTemplateInfo.id)) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMPtvTemplateManager", 2, "PtvTemplateAdapter getTemplatePosFromOut: " + i);
      }
      return i;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public PtvTemplateManager.PtvTemplateInfo a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    return (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    if (!bork.a())
    {
      QQToast.a(BaseApplicationImpl.getContext(), anzj.a(2131708698), 0).a();
      ThreadManager.excute(new QIMPtvTemplateAdapter.3(this), 64, null, true);
      return;
    }
    if (paramPtvTemplateInfo != null) {}
    int i;
    for (;;)
    {
      this.jdField_b_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = paramPtvTemplateInfo;
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) && (!this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id.equals("0"))) {
        break label262;
      }
      jdField_b_of_type_Int = paramPtvTemplateInfo.categoryId;
      jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.id;
      if (this.jdField_a_of_type_Bpvt != null)
      {
        this.jdField_a_of_type_Bpvt.a(null, "");
        jdField_a_of_type_JavaLangString = "";
        if ((aluf.jdField_a_of_type_Int == 2) && (jdField_b_of_type_JavaLangString.equals("0")) && (jdField_b_of_type_Int == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QIMPtvTemplateManager", 2, "onDrawBeautyFeature is in back_camera && no template is selected");
          }
          this.jdField_a_of_type_Bpvt.b(0);
          this.jdField_a_of_type_Bpvt.c(-1);
        }
        if (QLog.isColorLevel()) {
          QLog.i("QIMPtvTemplateManager", 2, "setVideoFilter null");
        }
      }
      this.jdField_a_of_type_Brhn.a(113, null);
      if (this.jdField_a_of_type_Bpvt != null) {
        this.jdField_a_of_type_Bpvt.a(null);
      }
      this.jdField_a_of_type_Brhn.a(jdField_b_of_type_JavaLangString);
      return;
      i = this.e;
      if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break;
      }
      paramPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    }
    label262:
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable)
    {
      jdField_b_of_type_Int = paramPtvTemplateInfo.categoryId;
      jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.id;
      String str = brhn.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
      if (this.jdField_a_of_type_Bpvt != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QIMPtvTemplateManager", 2, "setVideoFilter " + str + " kind " + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind);
        }
        if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind == 3)
        {
          this.jdField_a_of_type_Bpvt.a(str);
          str = "";
          this.jdField_a_of_type_Bpvt.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, str);
          jdField_a_of_type_JavaLangString = str;
          i = AdvancedProviderView.b();
          this.jdField_a_of_type_Bpvt.b(i);
          i = AdvancedProviderView.c();
          this.jdField_a_of_type_Bpvt.c(i);
        }
      }
      else
      {
        this.jdField_a_of_type_Brhn.a(paramPtvTemplateInfo, 111);
        this.jdField_a_of_type_Brhn.a(113, null);
        this.jdField_a_of_type_Brhn.a(jdField_b_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      bqyg.a("", "0X80075BA", this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id);
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind == 3) {
        bqyg.a("", "0X80083B9", this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id);
      }
      yup.a((Activity)this.jdField_a_of_type_AndroidContentContext, "face_element", String.valueOf(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.categoryId), this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id);
      return;
      this.jdField_a_of_type_Bpvt.a(null);
      break;
      if ((!this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading) && (!TextUtils.isEmpty(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) && (this.jdField_a_of_type_Brhn != null)) {
        if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind == 3) && (bhnv.b(this.jdField_a_of_type_AndroidContentContext)))
        {
          if (this.jdField_a_of_type_Bhpc == null) {
            this.jdField_a_of_type_Bhpc = bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(anzj.a(2131708701)).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131697598)).setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getString(2131694098), new bpmd(this)).setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690580), new bpmc(this));
          }
          try
          {
            if ((this.jdField_a_of_type_Bhpc == null) || (this.jdField_a_of_type_Bhpc.isShowing())) {
              continue;
            }
            this.jdField_a_of_type_Bhpc.show();
          }
          catch (Throwable paramPtvTemplateInfo) {}
        }
        else
        {
          ThreadManager.excute(new QIMPtvTemplateAdapter.6(this), 128, null, true);
          bpvy.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo).a();
          bqzu.a("shortvideo_download_effects", null);
        }
      }
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "PtvTemplateAdapter selectPtvTemplateFromout");
    }
    this.e = paramInt;
    c = paramInt;
    a(paramPtvTemplateInfo);
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 111) {
      if ((paramVarArgs != null) && (paramVarArgs.length == 1))
      {
        a(((bpnv)paramVarArgs[0]).a);
        notifyDataSetChanged();
      }
    }
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    label209:
    do
    {
      return;
      while (!paramVarArgs.hasNext())
      {
        do
        {
          do
          {
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
                      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramVarArgs.next();
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
              if (paramInt == 113)
              {
                notifyDataSetInvalidated();
                return;
              }
              if (paramInt != 114) {
                break label209;
              }
            } while ((paramVarArgs == null) || (paramVarArgs.length != 1));
            paramObject = (VideoMaterial)paramVarArgs[0];
            paramVarArgs = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          } while (!paramVarArgs.hasNext());
          localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramVarArgs.next();
          if ((paramObject == null) || (!paramObject.getId().equals(localPtvTemplateInfo.id))) {
            break;
          }
          localPtvTemplateInfo.editablewatermark = true;
          notifyDataSetChanged();
          return;
        } while ((paramInt != 115) || (paramVarArgs == null) || (paramVarArgs.length != 1));
        paramObject = (VideoMaterial)paramVarArgs[0];
        paramVarArgs = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramVarArgs.next();
    } while ((paramObject == null) || (paramObject.getId() == null) || (!paramObject.getId().equals(localPtvTemplateInfo.id)));
    localPtvTemplateInfo.editablewatermark = false;
    notifyDataSetChanged();
  }
  
  public void a(List<PtvTemplateManager.PtvTemplateInfo> paramList)
  {
    int i = 0;
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.e = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = new PtvTemplateManager.PtvTemplateInfo();
        localPtvTemplateInfo.id = "0";
        localPtvTemplateInfo.categoryId = 0;
        this.jdField_a_of_type_JavaUtilArrayList.add(localPtvTemplateInfo);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      return;
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
    a(paramInt);
    PtvTemplateItemView localPtvTemplateItemView;
    if ((paramView == null) || (!(paramView instanceof PtvTemplateItemView)))
    {
      localPtvTemplateItemView = new PtvTemplateItemView(this.jdField_a_of_type_AndroidContentContext);
      localPtvTemplateItemView.a();
    }
    for (;;)
    {
      localPtvTemplateItemView.a(paramInt, (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_a_of_type_Bpme, jdField_b_of_type_Int, jdField_b_of_type_JavaLangString, jdField_a_of_type_Boolean);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localPtvTemplateItemView;
      localPtvTemplateItemView = (PtvTemplateItemView)paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bplz
 * JD-Core Version:    0.7.0.1
 */