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

public class binu
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements View.OnClickListener, axgj, biqy
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private biob jdField_a_of_type_Biob;
  private biqk jdField_a_of_type_Biqk;
  public biqn a;
  private AEGridView jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView;
  public ArrayList<biqn> a;
  private boolean jdField_a_of_type_Boolean;
  
  public binu(Context paramContext, AEGridView paramAEGridView, biob parambiob, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Biqk = ((biqk)bjae.a(18));
    this.jdField_a_of_type_Biob = parambiob;
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView = paramAEGridView;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private int a(biqn parambiqn)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((biqn)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(parambiqn.jdField_a_of_type_JavaLangString)) {
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
        if ((paramObject.getId() != null) && (paramObject.getId().equals(((biqn)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))
        {
          ((biqn)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean = paramBoolean;
          notifyItemChanged(i, Integer.valueOf(1));
          return;
        }
        i += 1;
      }
    }
  }
  
  private void b(biqn parambiqn)
  {
    if (parambiqn == null) {}
    while ((parambiqn.e) || (TextUtils.isEmpty(parambiqn.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Biqk == null)) {
      return;
    }
    if (!bbev.b(this.jdField_a_of_type_AndroidContentContext))
    {
      d(parambiqn);
      return;
    }
    c(parambiqn);
  }
  
  private void b(biqn parambiqn, int paramInt)
  {
    boolean bool = true;
    if (parambiqn == null) {}
    label408:
    for (;;)
    {
      return;
      bizg.a().b(-1);
      bizg.a().g("none");
      bizg.a().f("1");
      bizg.a().c(0);
      Object localObject;
      if (parambiqn != null)
      {
        bizc.a().b(parambiqn.jdField_a_of_type_JavaLangString);
        bizq.b("AEMaterialAdapter", "【Select Material】：" + parambiqn.jdField_a_of_type_JavaLangString);
        bizq.b("AEMaterialAdapter", "【Select Material】Usable :" + parambiqn.d);
        if ((parambiqn != null) && (!TextUtils.isEmpty(parambiqn.jdField_a_of_type_JavaLangString)) && (!biqn.a(parambiqn))) {
          break label215;
        }
        if (this.jdField_a_of_type_Biob != null) {
          this.jdField_a_of_type_Biob.a();
        }
        parambiqn = this.jdField_a_of_type_Biqk;
        localObject = biqn.jdField_a_of_type_Biqn;
        if (this.jdField_a_of_type_Boolean) {
          break label210;
        }
      }
      label210:
      for (bool = true;; bool = false)
      {
        parambiqn.a((biqn)localObject, bool);
        QLog.d("AEMaterialAdapter", 4, "### [material panel] select material none");
        ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().removeExtra("widgetinfo");
        return;
        bizc.a().b("null");
        bizq.b("AEMaterialAdapter", "【Select Material】：null");
        break;
      }
      label215:
      if (parambiqn.a())
      {
        vzz.a(this.jdField_a_of_type_AndroidContentContext, parambiqn);
        return;
      }
      if (parambiqn.d)
      {
        ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().putExtra("widgetinfo", "camera^" + parambiqn.jdField_a_of_type_JavaLangString);
        if (!FeatureManager.isBasicFeaturesFunctionReady())
        {
          bcpw.a(BaseApplicationImpl.getContext(), ajyc.a(2131709818), 0).a();
          ThreadManager.excute(new AEMaterialAdapter.1(this), 64, null, true);
          return;
        }
        if (this.jdField_a_of_type_Biob != null) {
          this.jdField_a_of_type_Biob.a(parambiqn);
        }
        localObject = this.jdField_a_of_type_Biqk;
        if (!this.jdField_a_of_type_Boolean)
        {
          ((biqk)localObject).a(parambiqn, bool);
          QLog.d("AEMaterialAdapter", 4, "### [material panel] select material " + parambiqn.jdField_a_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean) {
          break label408;
        }
        this.jdField_a_of_type_Biqk.a(parambiqn);
        return;
        bool = false;
        break;
        b(parambiqn);
      }
    }
  }
  
  private void c(biqn parambiqn)
  {
    parambiqn = bbcv.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(ajyc.a(2131709821)).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131698317)).setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getString(2131694793), new binw(this, parambiqn)).setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690596), new binv(this));
    if (parambiqn != null) {}
    try
    {
      if (!parambiqn.isShowing()) {
        parambiqn.show();
      }
      return;
    }
    catch (Throwable parambiqn) {}
  }
  
  private void d(biqn parambiqn)
  {
    this.jdField_a_of_type_Biqk.a(this.jdField_a_of_type_Biqk.a(), parambiqn, this);
  }
  
  public void a(biqn parambiqn)
  {
    b(parambiqn, a(parambiqn));
  }
  
  public void a(biqn parambiqn, int paramInt)
  {
    paramInt = a(parambiqn);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.4(this, paramInt));
  }
  
  public void a(biqn parambiqn, boolean paramBoolean)
  {
    if (parambiqn == null) {}
    do
    {
      int i;
      do
      {
        return;
        i = a(parambiqn);
      } while (i <= 0);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().putExtra("widgetinfo", "camera^" + parambiqn.jdField_a_of_type_JavaLangString);
      ThreadManager.getUIHandler().post(new AEMaterialAdapter.2(this, i, parambiqn, paramBoolean));
    } while (paramBoolean);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.3(this));
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 113) {
      if (biqk.a() != null) {
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
        a(((biqj)paramVarArgs[0]).a);
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
  
  public void a(List<biqn> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(biqn.jdField_a_of_type_Biqn);
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
    biqn localbiqn = (biqn)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localbiqn == null) {}
    do
    {
      return;
      if ((paramViewHolder instanceof bioj))
      {
        paramViewHolder = (bioj)paramViewHolder;
        if (localbiqn.equals(biqk.a()))
        {
          paramViewHolder.a();
          return;
        }
        paramViewHolder.b();
        return;
      }
    } while (!(paramViewHolder instanceof biok));
    paramViewHolder = (biok)paramViewHolder;
    if ((localbiqn.equals(biqk.a())) && (localbiqn.d))
    {
      paramViewHolder.a(2, localbiqn);
      return;
    }
    localbiqn.jdField_a_of_type_Boolean = false;
    paramViewHolder.a(1, localbiqn);
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView.getChildAdapterPosition(paramView);
    if (i == -1) {
      return;
    }
    paramView = (biqn)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    if ((this.jdField_a_of_type_Biqn != null) && (!this.jdField_a_of_type_Biqn.equals(paramView)))
    {
      this.jdField_a_of_type_Biqn.b = false;
      this.jdField_a_of_type_Biqn.c = false;
    }
    this.jdField_a_of_type_Biqn = paramView;
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
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558488, paramViewGroup, false);
      paramViewGroup = new bioj(localView);
    }
    for (;;)
    {
      localView.setOnClickListener(this);
      return paramViewGroup;
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558487, paramViewGroup, false);
      paramViewGroup = new biok(localView);
      paramViewGroup.a(this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     binu
 * JD-Core Version:    0.7.0.1
 */