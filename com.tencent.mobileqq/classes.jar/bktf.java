import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import dov.com.qq.im.ae.camera.ui.panel.AEGridView;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.1;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.2;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.3;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.4;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class bktf
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements View.OnClickListener, azbr, bkwg
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bktm jdField_a_of_type_Bktm;
  private bkvr jdField_a_of_type_Bkvr;
  public bkvu a;
  private AEGridView jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView;
  public ArrayList<bkvu> a;
  private boolean jdField_a_of_type_Boolean;
  
  public bktf(Context paramContext, AEGridView paramAEGridView, bktm parambktm, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Bkvr = ((bkvr)blmf.a(18));
    this.jdField_a_of_type_Bktm = parambktm;
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView = paramAEGridView;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private int a(bkvu parambkvu)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((bkvu)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(parambkvu.jdField_a_of_type_JavaLangString)) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (VideoMaterial)paramObject;
    if (paramObject == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if ((paramObject.getId() != null) && (paramObject.getId().equals(((bkvu)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))
        {
          ((bkvu)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean = paramBoolean;
          notifyItemChanged(i, Integer.valueOf(1));
          return;
        }
        i += 1;
      }
    }
  }
  
  private void b(bkvu parambkvu)
  {
    if (parambkvu == null) {}
    while ((parambkvu.e) || (TextUtils.isEmpty(parambkvu.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bkvr == null)) {
      return;
    }
    if (!bdee.b(this.jdField_a_of_type_AndroidContentContext))
    {
      d(parambkvu);
      return;
    }
    c(parambkvu);
  }
  
  private void b(bkvu parambkvu, int paramInt)
  {
    boolean bool = true;
    if (parambkvu == null) {}
    label453:
    for (;;)
    {
      return;
      bler.a().b(-1);
      bler.a().g("none");
      bler.a().f("1");
      bler.a().c(0);
      Object localObject;
      if (parambkvu != null)
      {
        blen.a().c(parambkvu.jdField_a_of_type_JavaLangString);
        blfg.b("AEMaterialAdapter", "【Select Material】：" + parambkvu.jdField_a_of_type_JavaLangString);
        blfg.b("AEMaterialAdapter", "【Select Material】Usable :" + parambkvu.d);
        if ((parambkvu != null) && (!TextUtils.isEmpty(parambkvu.jdField_a_of_type_JavaLangString)) && (!bkvu.a(parambkvu))) {
          break label215;
        }
        if (this.jdField_a_of_type_Bktm != null) {
          this.jdField_a_of_type_Bktm.a();
        }
        parambkvu = this.jdField_a_of_type_Bkvr;
        localObject = bkvu.jdField_a_of_type_Bkvu;
        if (this.jdField_a_of_type_Boolean) {
          break label210;
        }
      }
      label210:
      for (bool = true;; bool = false)
      {
        parambkvu.a((bkvu)localObject, bool);
        QLog.d("AEMaterialAdapter", 4, "### [material panel] select material none");
        ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().removeExtra("widgetinfo");
        return;
        blen.a().c("null");
        blfg.b("AEMaterialAdapter", "【Select Material】：null");
        break;
      }
      label215:
      if (parambkvu.a())
      {
        xoo.a(this.jdField_a_of_type_AndroidContentContext, parambkvu);
        return;
      }
      if (parambkvu.d)
      {
        localObject = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
        ((Intent)localObject).putExtra("widgetinfo", "camera^" + parambkvu.jdField_a_of_type_JavaLangString);
        String str = parambkvu.i;
        blfg.b("AEMaterialAdapter", "selectSpecificMaterial---塞拍同款名 takeSameName=" + str);
        ((Intent)localObject).putExtra("key_camera_material_name", str);
        if (!FeatureManager.isBasicFeaturesFunctionReady())
        {
          QQToast.a(BaseApplicationImpl.getContext(), alpo.a(2131710201), 0).a();
          ThreadManager.excute(new AEMaterialAdapter.1(this), 64, null, true);
          return;
        }
        if (this.jdField_a_of_type_Bktm != null) {
          this.jdField_a_of_type_Bktm.a(parambkvu);
        }
        localObject = this.jdField_a_of_type_Bkvr;
        if (!this.jdField_a_of_type_Boolean)
        {
          ((bkvr)localObject).a(parambkvu, bool);
          QLog.d("AEMaterialAdapter", 4, "### [material panel] select material " + parambkvu.jdField_a_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean) {
          break label453;
        }
        this.jdField_a_of_type_Bkvr.a(parambkvu);
        return;
        bool = false;
        break;
        b(parambkvu);
      }
    }
  }
  
  private void c(bkvu parambkvu)
  {
    parambkvu = bdcd.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(alpo.a(2131710204)).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131698617)).setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getString(2131694951), new bkth(this, parambkvu)).setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690648), new bktg(this));
    if (parambkvu != null) {}
    try
    {
      if (!parambkvu.isShowing()) {
        parambkvu.show();
      }
      return;
    }
    catch (Throwable parambkvu) {}
  }
  
  private void d(bkvu parambkvu)
  {
    this.jdField_a_of_type_Bkvr.a(this.jdField_a_of_type_Bkvr.a(), parambkvu, this);
  }
  
  public void a(bkvu parambkvu)
  {
    b(parambkvu, a(parambkvu));
  }
  
  public void a(bkvu parambkvu, int paramInt)
  {
    paramInt = a(parambkvu);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.4(this, paramInt));
  }
  
  public void a(bkvu parambkvu, boolean paramBoolean)
  {
    if (parambkvu == null) {}
    do
    {
      int i;
      do
      {
        return;
        i = a(parambkvu);
      } while (i <= 0);
      ThreadManager.getUIHandler().post(new AEMaterialAdapter.2(this, i, parambkvu, paramBoolean));
    } while (paramBoolean);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.3(this));
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 113) {
      if (bkvr.a() != null) {
        notifyDataSetChanged();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt != 111) {
            break;
          }
        } while ((paramVarArgs == null) || (paramVarArgs.length != 1) || (!this.jdField_a_of_type_Boolean));
        a(((bkvq)paramVarArgs[0]).a);
        notifyDataSetChanged();
        return;
        if (paramInt != 114) {
          break;
        }
      } while ((paramVarArgs == null) || (paramVarArgs.length != 1));
      a(true, paramVarArgs[0]);
      return;
    } while ((paramInt != 115) || (paramVarArgs == null) || (paramVarArgs.length != 1));
    a(false, paramVarArgs[0]);
  }
  
  public void a(List<bkvu> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(bkvu.jdField_a_of_type_Bkvu);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    bkvu localbkvu = (bkvu)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localbkvu == null) {}
    do
    {
      return;
      if ((paramViewHolder instanceof bktu))
      {
        paramViewHolder = (bktu)paramViewHolder;
        if (localbkvu.equals(bkvr.a()))
        {
          paramViewHolder.a();
          return;
        }
        paramViewHolder.b();
        return;
      }
    } while (!(paramViewHolder instanceof bktv));
    paramViewHolder = (bktv)paramViewHolder;
    if ((localbkvu.equals(bkvr.a())) && (localbkvu.d))
    {
      paramViewHolder.a(2, localbkvu);
      return;
    }
    localbkvu.jdField_a_of_type_Boolean = false;
    paramViewHolder.a(1, localbkvu);
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView.getChildAdapterPosition(paramView);
    if (i == -1) {
      return;
    }
    paramView = (bkvu)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    if ((this.jdField_a_of_type_Bkvu != null) && (!this.jdField_a_of_type_Bkvu.equals(paramView)))
    {
      this.jdField_a_of_type_Bkvu.b = false;
      this.jdField_a_of_type_Bkvu.c = false;
    }
    this.jdField_a_of_type_Bkvu = paramView;
    if (paramView.b) {
      paramView.c = true;
    }
    for (;;)
    {
      b(paramView, i);
      return;
      paramView.b = true;
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558490, paramViewGroup, false);
      paramViewGroup = new bktu(localView);
    }
    for (;;)
    {
      localView.setOnClickListener(this);
      return paramViewGroup;
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558489, paramViewGroup, false);
      paramViewGroup = new bktv(localView);
      paramViewGroup.a(this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bktf
 * JD-Core Version:    0.7.0.1
 */