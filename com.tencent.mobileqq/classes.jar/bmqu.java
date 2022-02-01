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
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.widget.GridView;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.3;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.6;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bmqu
  extends BaseAdapter
  implements bbsx
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
  public bmqz a;
  private bmyx jdField_a_of_type_Bmyx;
  private boay jdField_a_of_type_Boay = new bmqw(this);
  public boba a;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
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
  
  public bmqu(Context paramContext, GridView paramGridView, bmyx parambmyx, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Bmqz = new bmqv(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_a_of_type_Boba = ((boba)bmql.a(3));
    this.jdField_a_of_type_Bmyx = parambmyx;
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
    if (!AEResUtil.isAEBaseSoReady())
    {
      QQToast.a(BaseApplicationImpl.getContext(), amtj.a(2131708930), 0).a();
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
      if (this.jdField_a_of_type_Bmyx != null)
      {
        this.jdField_a_of_type_Bmyx.a(null, "");
        jdField_a_of_type_JavaLangString = "";
        if ((akrw.jdField_a_of_type_Int == 2) && (jdField_b_of_type_JavaLangString.equals("0")) && (jdField_b_of_type_Int == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QIMPtvTemplateManager", 2, "onDrawBeautyFeature is in back_camera && no template is selected");
          }
          this.jdField_a_of_type_Bmyx.a(0);
          this.jdField_a_of_type_Bmyx.b(-1);
        }
        if (QLog.isColorLevel()) {
          QLog.i("QIMPtvTemplateManager", 2, "setVideoFilter null");
        }
      }
      this.jdField_a_of_type_Boba.a(113, null);
      if (this.jdField_a_of_type_Bmyx != null) {
        this.jdField_a_of_type_Bmyx.a(null);
      }
      this.jdField_a_of_type_Boba.a(jdField_b_of_type_JavaLangString);
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
      String str = boba.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
      if (this.jdField_a_of_type_Bmyx != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QIMPtvTemplateManager", 2, "setVideoFilter " + str + " kind " + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind);
        }
        if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind == 3)
        {
          this.jdField_a_of_type_Bmyx.a(str);
          str = "";
          this.jdField_a_of_type_Bmyx.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, str);
          jdField_a_of_type_JavaLangString = str;
          i = AdvancedProviderView.b();
          this.jdField_a_of_type_Bmyx.a(i);
          i = AdvancedProviderView.c();
          this.jdField_a_of_type_Bmyx.b(i);
        }
      }
      else
      {
        this.jdField_a_of_type_Boba.a(paramPtvTemplateInfo, 111);
        this.jdField_a_of_type_Boba.a(113, null);
        this.jdField_a_of_type_Boba.a(jdField_b_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      bnsi.a("", "0X80075BA", this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id);
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind == 3) {
        bnsi.a("", "0X80083B9", this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id);
      }
      xwa.a((Activity)this.jdField_a_of_type_AndroidContentContext, "face_element", String.valueOf(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.categoryId), this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id);
      return;
      this.jdField_a_of_type_Bmyx.a(null);
      break;
      if ((!this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading) && (!TextUtils.isEmpty(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) && (this.jdField_a_of_type_Boba != null)) {
        if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind == 3) && (NetworkUtil.isMobileNetWork(this.jdField_a_of_type_AndroidContentContext)))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(amtj.a(2131708933)).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131697744)).setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getString(2131694201), new bmqy(this)).setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690620), new bmqx(this));
          }
          try
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
          }
          catch (Throwable paramPtvTemplateInfo) {}
        }
        else
        {
          ThreadManager.excute(new QIMPtvTemplateAdapter.6(this), 128, null, true);
          bmzd.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo).a();
          bntw.a("shortvideo_download_effects", null);
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
      localPtvTemplateItemView.a(paramInt, (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_a_of_type_Bmqz, jdField_b_of_type_Int, jdField_b_of_type_JavaLangString, jdField_a_of_type_Boolean);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localPtvTemplateItemView;
      localPtvTemplateItemView = (PtvTemplateItemView)paramView;
    }
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 111) {
      if ((paramVarArgs != null) && (paramVarArgs.length == 1))
      {
        a(((bmsq)paramVarArgs[0]).a);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqu
 * JD-Core Version:    0.7.0.1
 */