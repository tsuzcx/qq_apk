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

public class biol
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements View.OnClickListener, axgl, birp
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bios jdField_a_of_type_Bios;
  private birb jdField_a_of_type_Birb;
  public bire a;
  private AEGridView jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView;
  public ArrayList<bire> a;
  private boolean jdField_a_of_type_Boolean;
  
  public biol(Context paramContext, AEGridView paramAEGridView, bios parambios, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Birb = ((birb)bjav.a(18));
    this.jdField_a_of_type_Bios = parambios;
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView = paramAEGridView;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private int a(bire parambire)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((bire)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(parambire.jdField_a_of_type_JavaLangString)) {
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
        if ((paramObject.getId() != null) && (paramObject.getId().equals(((bire)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))
        {
          ((bire)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean = paramBoolean;
          notifyItemChanged(i, Integer.valueOf(1));
          return;
        }
        i += 1;
      }
    }
  }
  
  private void b(bire parambire)
  {
    if (parambire == null) {}
    while ((parambire.e) || (TextUtils.isEmpty(parambire.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Birb == null)) {
      return;
    }
    if (!bbfj.b(this.jdField_a_of_type_AndroidContentContext))
    {
      d(parambire);
      return;
    }
    c(parambire);
  }
  
  private void b(bire parambire, int paramInt)
  {
    boolean bool = true;
    if (parambire == null) {}
    label408:
    for (;;)
    {
      return;
      bizx.a().b(-1);
      bizx.a().g("none");
      bizx.a().f("1");
      bizx.a().c(0);
      Object localObject;
      if (parambire != null)
      {
        bizt.a().b(parambire.jdField_a_of_type_JavaLangString);
        bjah.b("AEMaterialAdapter", "【Select Material】：" + parambire.jdField_a_of_type_JavaLangString);
        bjah.b("AEMaterialAdapter", "【Select Material】Usable :" + parambire.d);
        if ((parambire != null) && (!TextUtils.isEmpty(parambire.jdField_a_of_type_JavaLangString)) && (!bire.a(parambire))) {
          break label215;
        }
        if (this.jdField_a_of_type_Bios != null) {
          this.jdField_a_of_type_Bios.a();
        }
        parambire = this.jdField_a_of_type_Birb;
        localObject = bire.jdField_a_of_type_Bire;
        if (this.jdField_a_of_type_Boolean) {
          break label210;
        }
      }
      label210:
      for (bool = true;; bool = false)
      {
        parambire.a((bire)localObject, bool);
        QLog.d("AEMaterialAdapter", 4, "### [material panel] select material none");
        ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().removeExtra("widgetinfo");
        return;
        bizt.a().b("null");
        bjah.b("AEMaterialAdapter", "【Select Material】：null");
        break;
      }
      label215:
      if (parambire.a())
      {
        vzw.a(this.jdField_a_of_type_AndroidContentContext, parambire);
        return;
      }
      if (parambire.d)
      {
        ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().putExtra("widgetinfo", "camera^" + parambire.jdField_a_of_type_JavaLangString);
        if (!FeatureManager.isBasicFeaturesFunctionReady())
        {
          bcql.a(BaseApplicationImpl.getContext(), ajya.a(2131709829), 0).a();
          ThreadManager.excute(new AEMaterialAdapter.1(this), 64, null, true);
          return;
        }
        if (this.jdField_a_of_type_Bios != null) {
          this.jdField_a_of_type_Bios.a(parambire);
        }
        localObject = this.jdField_a_of_type_Birb;
        if (!this.jdField_a_of_type_Boolean)
        {
          ((birb)localObject).a(parambire, bool);
          QLog.d("AEMaterialAdapter", 4, "### [material panel] select material " + parambire.jdField_a_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean) {
          break label408;
        }
        this.jdField_a_of_type_Birb.a(parambire);
        return;
        bool = false;
        break;
        b(parambire);
      }
    }
  }
  
  private void c(bire parambire)
  {
    parambire = bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(ajya.a(2131709832)).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131698327)).setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getString(2131694794), new bion(this, parambire)).setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690596), new biom(this));
    if (parambire != null) {}
    try
    {
      if (!parambire.isShowing()) {
        parambire.show();
      }
      return;
    }
    catch (Throwable parambire) {}
  }
  
  private void d(bire parambire)
  {
    this.jdField_a_of_type_Birb.a(this.jdField_a_of_type_Birb.a(), parambire, this);
  }
  
  public void a(bire parambire)
  {
    b(parambire, a(parambire));
  }
  
  public void a(bire parambire, int paramInt)
  {
    paramInt = a(parambire);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.4(this, paramInt));
  }
  
  public void a(bire parambire, boolean paramBoolean)
  {
    if (parambire == null) {}
    do
    {
      int i;
      do
      {
        return;
        i = a(parambire);
      } while (i <= 0);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().putExtra("widgetinfo", "camera^" + parambire.jdField_a_of_type_JavaLangString);
      ThreadManager.getUIHandler().post(new AEMaterialAdapter.2(this, i, parambire, paramBoolean));
    } while (paramBoolean);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.3(this));
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 113) {
      if (birb.a() != null) {
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
        a(((bira)paramVarArgs[0]).a);
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
  
  public void a(List<bire> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(bire.jdField_a_of_type_Bire);
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
    bire localbire = (bire)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localbire == null) {}
    do
    {
      return;
      if ((paramViewHolder instanceof bipa))
      {
        paramViewHolder = (bipa)paramViewHolder;
        if (localbire.equals(birb.a()))
        {
          paramViewHolder.a();
          return;
        }
        paramViewHolder.b();
        return;
      }
    } while (!(paramViewHolder instanceof bipb));
    paramViewHolder = (bipb)paramViewHolder;
    if ((localbire.equals(birb.a())) && (localbire.d))
    {
      paramViewHolder.a(2, localbire);
      return;
    }
    localbire.jdField_a_of_type_Boolean = false;
    paramViewHolder.a(1, localbire);
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView.getChildAdapterPosition(paramView);
    if (i == -1) {
      return;
    }
    paramView = (bire)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    if ((this.jdField_a_of_type_Bire != null) && (!this.jdField_a_of_type_Bire.equals(paramView)))
    {
      this.jdField_a_of_type_Bire.b = false;
      this.jdField_a_of_type_Bire.c = false;
    }
    this.jdField_a_of_type_Bire = paramView;
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
      paramViewGroup = new bipa(localView);
    }
    for (;;)
    {
      localView.setOnClickListener(this);
      return paramViewGroup;
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558487, paramViewGroup, false);
      paramViewGroup = new bipb(localView);
      paramViewGroup.a(this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biol
 * JD-Core Version:    0.7.0.1
 */