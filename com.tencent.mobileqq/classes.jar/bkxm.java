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

public class bkxm
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements View.OnClickListener, azga, blan
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bkxt jdField_a_of_type_Bkxt;
  private bkzy jdField_a_of_type_Bkzy;
  public blab a;
  private AEGridView jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView;
  public ArrayList<blab> a;
  private boolean jdField_a_of_type_Boolean;
  
  public bkxm(Context paramContext, AEGridView paramAEGridView, bkxt parambkxt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Bkzy = ((bkzy)blqr.a(18));
    this.jdField_a_of_type_Bkxt = parambkxt;
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView = paramAEGridView;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private int a(blab paramblab)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((blab)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramblab.jdField_a_of_type_JavaLangString)) {
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
        if ((paramObject.getId() != null) && (paramObject.getId().equals(((blab)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))
        {
          ((blab)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean = paramBoolean;
          notifyItemChanged(i, Integer.valueOf(1));
          return;
        }
        i += 1;
      }
    }
  }
  
  private void b(blab paramblab)
  {
    if (paramblab == null) {}
    while ((paramblab.e) || (TextUtils.isEmpty(paramblab.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bkzy == null)) {
      return;
    }
    if (!bdin.b(this.jdField_a_of_type_AndroidContentContext))
    {
      d(paramblab);
      return;
    }
    c(paramblab);
  }
  
  private void b(blab paramblab, int paramInt)
  {
    boolean bool = true;
    if (paramblab == null) {}
    label453:
    for (;;)
    {
      return;
      bliy.a().b(-1);
      bliy.a().g("none");
      bliy.a().f("1");
      bliy.a().c(0);
      Object localObject;
      if (paramblab != null)
      {
        bliu.a().c(paramblab.jdField_a_of_type_JavaLangString);
        bljn.b("AEMaterialAdapter", "【Select Material】：" + paramblab.jdField_a_of_type_JavaLangString);
        bljn.b("AEMaterialAdapter", "【Select Material】Usable :" + paramblab.d);
        if ((paramblab != null) && (!TextUtils.isEmpty(paramblab.jdField_a_of_type_JavaLangString)) && (!blab.a(paramblab))) {
          break label215;
        }
        if (this.jdField_a_of_type_Bkxt != null) {
          this.jdField_a_of_type_Bkxt.a();
        }
        paramblab = this.jdField_a_of_type_Bkzy;
        localObject = blab.jdField_a_of_type_Blab;
        if (this.jdField_a_of_type_Boolean) {
          break label210;
        }
      }
      label210:
      for (bool = true;; bool = false)
      {
        paramblab.a((blab)localObject, bool);
        QLog.d("AEMaterialAdapter", 4, "### [material panel] select material none");
        ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().removeExtra("widgetinfo");
        return;
        bliu.a().c("null");
        bljn.b("AEMaterialAdapter", "【Select Material】：null");
        break;
      }
      label215:
      if (paramblab.a())
      {
        xsx.a(this.jdField_a_of_type_AndroidContentContext, paramblab);
        return;
      }
      if (paramblab.d)
      {
        localObject = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
        ((Intent)localObject).putExtra("widgetinfo", "camera^" + paramblab.jdField_a_of_type_JavaLangString);
        String str = paramblab.i;
        bljn.b("AEMaterialAdapter", "selectSpecificMaterial---塞拍同款名 takeSameName=" + str);
        ((Intent)localObject).putExtra("key_camera_material_name", str);
        if (!FeatureManager.isBasicFeaturesFunctionReady())
        {
          QQToast.a(BaseApplicationImpl.getContext(), alud.a(2131710213), 0).a();
          ThreadManager.excute(new AEMaterialAdapter.1(this), 64, null, true);
          return;
        }
        if (this.jdField_a_of_type_Bkxt != null) {
          this.jdField_a_of_type_Bkxt.a(paramblab);
        }
        localObject = this.jdField_a_of_type_Bkzy;
        if (!this.jdField_a_of_type_Boolean)
        {
          ((bkzy)localObject).a(paramblab, bool);
          QLog.d("AEMaterialAdapter", 4, "### [material panel] select material " + paramblab.jdField_a_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean) {
          break label453;
        }
        this.jdField_a_of_type_Bkzy.a(paramblab);
        return;
        bool = false;
        break;
        b(paramblab);
      }
    }
  }
  
  private void c(blab paramblab)
  {
    paramblab = bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(alud.a(2131710216)).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131698629)).setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getString(2131694953), new bkxo(this, paramblab)).setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690648), new bkxn(this));
    if (paramblab != null) {}
    try
    {
      if (!paramblab.isShowing()) {
        paramblab.show();
      }
      return;
    }
    catch (Throwable paramblab) {}
  }
  
  private void d(blab paramblab)
  {
    this.jdField_a_of_type_Bkzy.a(this.jdField_a_of_type_Bkzy.a(), paramblab, this);
  }
  
  public void a(blab paramblab)
  {
    b(paramblab, a(paramblab));
  }
  
  public void a(blab paramblab, int paramInt)
  {
    paramInt = a(paramblab);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.4(this, paramInt));
  }
  
  public void a(blab paramblab, boolean paramBoolean)
  {
    if (paramblab == null) {}
    do
    {
      int i;
      do
      {
        return;
        i = a(paramblab);
      } while (i <= 0);
      ThreadManager.getUIHandler().post(new AEMaterialAdapter.2(this, i, paramblab, paramBoolean));
    } while (paramBoolean);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.3(this));
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 113) {
      if (bkzy.a() != null) {
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
        a(((bkzx)paramVarArgs[0]).a);
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
  
  public void a(List<blab> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(blab.jdField_a_of_type_Blab);
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
    blab localblab = (blab)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localblab == null) {}
    do
    {
      return;
      if ((paramViewHolder instanceof bkyb))
      {
        paramViewHolder = (bkyb)paramViewHolder;
        if (localblab.equals(bkzy.a()))
        {
          paramViewHolder.a();
          return;
        }
        paramViewHolder.b();
        return;
      }
    } while (!(paramViewHolder instanceof bkyc));
    paramViewHolder = (bkyc)paramViewHolder;
    if ((localblab.equals(bkzy.a())) && (localblab.d))
    {
      paramViewHolder.a(2, localblab);
      return;
    }
    localblab.jdField_a_of_type_Boolean = false;
    paramViewHolder.a(1, localblab);
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView.getChildAdapterPosition(paramView);
    if (i == -1) {
      return;
    }
    paramView = (blab)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    if ((this.jdField_a_of_type_Blab != null) && (!this.jdField_a_of_type_Blab.equals(paramView)))
    {
      this.jdField_a_of_type_Blab.b = false;
      this.jdField_a_of_type_Blab.c = false;
    }
    this.jdField_a_of_type_Blab = paramView;
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
      paramViewGroup = new bkyb(localView);
    }
    for (;;)
    {
      localView.setOnClickListener(this);
      return paramViewGroup;
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558489, paramViewGroup, false);
      paramViewGroup = new bkyc(localView);
      paramViewGroup.a(this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxm
 * JD-Core Version:    0.7.0.1
 */