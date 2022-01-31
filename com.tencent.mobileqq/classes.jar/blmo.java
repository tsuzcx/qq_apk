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
import com.tencent.ttpic.openapi.manager.FeatureManager;
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

public class blmo
  extends BaseAdapter
  implements azbr
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
  private bdfq jdField_a_of_type_Bdfq;
  public blmt a;
  private blwi jdField_a_of_type_Blwi;
  private bnkw jdField_a_of_type_Bnkw = new blmq(this);
  public bnkz a;
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
  
  public blmo(Context paramContext, GridView paramGridView, blwi paramblwi, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Blmt = new blmp(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_a_of_type_Bnkz = ((bnkz)blmf.a(3));
    this.jdField_a_of_type_Blwi = paramblwi;
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
    if (!FeatureManager.isBasicFeaturesFunctionReady())
    {
      QQToast.a(BaseApplicationImpl.getContext(), alpo.a(2131710201), 0).a();
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
      if (this.jdField_a_of_type_Blwi != null)
      {
        this.jdField_a_of_type_Blwi.a(null, "");
        jdField_a_of_type_JavaLangString = "";
        if ((ajli.jdField_a_of_type_Int == 2) && (jdField_b_of_type_JavaLangString.equals("0")) && (jdField_b_of_type_Int == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QIMPtvTemplateManager", 2, "onDrawBeautyFeature is in back_camera && no template is selected");
          }
          this.jdField_a_of_type_Blwi.b(0);
          this.jdField_a_of_type_Blwi.c(-1);
        }
        if (QLog.isColorLevel()) {
          QLog.i("QIMPtvTemplateManager", 2, "setVideoFilter null");
        }
      }
      this.jdField_a_of_type_Bnkz.a(113, null);
      if (this.jdField_a_of_type_Blwi != null) {
        this.jdField_a_of_type_Blwi.a(null);
      }
      this.jdField_a_of_type_Bnkz.a(jdField_b_of_type_JavaLangString);
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
      String str = bnkz.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
      if (this.jdField_a_of_type_Blwi != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QIMPtvTemplateManager", 2, "setVideoFilter " + str + " kind " + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind);
        }
        if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind == 3)
        {
          this.jdField_a_of_type_Blwi.a(str);
          str = "";
          this.jdField_a_of_type_Blwi.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, str);
          jdField_a_of_type_JavaLangString = str;
          i = AdvancedProviderView.b();
          this.jdField_a_of_type_Blwi.b(i);
          i = AdvancedProviderView.c();
          this.jdField_a_of_type_Blwi.c(i);
        }
      }
      else
      {
        this.jdField_a_of_type_Bnkz.a(paramPtvTemplateInfo, 111);
        this.jdField_a_of_type_Bnkz.a(113, null);
        this.jdField_a_of_type_Bnkz.a(jdField_b_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      bnaw.a("", "0X80075BA", this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id);
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind == 3) {
        bnaw.a("", "0X80083B9", this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id);
      }
      wta.a((Activity)this.jdField_a_of_type_AndroidContentContext, "face_element", String.valueOf(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.categoryId), this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id);
      return;
      this.jdField_a_of_type_Blwi.a(null);
      break;
      if ((!this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading) && (!TextUtils.isEmpty(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) && (this.jdField_a_of_type_Bnkz != null)) {
        if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind == 3) && (bdee.b(this.jdField_a_of_type_AndroidContentContext)))
        {
          if (this.jdField_a_of_type_Bdfq == null) {
            this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(alpo.a(2131710204)).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131698617)).setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getString(2131694951), new blms(this)).setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690648), new blmr(this));
          }
          try
          {
            if ((this.jdField_a_of_type_Bdfq == null) || (this.jdField_a_of_type_Bdfq.isShowing())) {
              continue;
            }
            this.jdField_a_of_type_Bdfq.show();
          }
          catch (Throwable paramPtvTemplateInfo) {}
        }
        else
        {
          ThreadManager.excute(new QIMPtvTemplateAdapter.6(this), 128, null, true);
          blwn.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo).a();
          bnck.a("shortvideo_download_effects", null);
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
        a(((blok)paramVarArgs[0]).a);
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
    if ((paramView == null) || (!(paramView instanceof PtvTemplateItemView)))
    {
      paramView = new PtvTemplateItemView(this.jdField_a_of_type_AndroidContentContext);
      paramView.a();
    }
    for (;;)
    {
      paramView.a(paramInt, (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_a_of_type_Blmt, jdField_b_of_type_Int, jdField_b_of_type_JavaLangString, jdField_a_of_type_Boolean);
      return paramView;
      paramView = (PtvTemplateItemView)paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmo
 * JD-Core Version:    0.7.0.1
 */