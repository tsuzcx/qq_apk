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
import dov.com.qq.im.AECamera.panel.material.AEGridView;
import dov.com.qq.im.AECamera.panel.material.AEMaterialAdapter.1;
import dov.com.qq.im.AECamera.panel.material.AEMaterialAdapter.2;
import dov.com.qq.im.AECamera.panel.material.AEMaterialAdapter.3;
import dov.com.qq.im.AECamera.panel.material.AEMaterialAdapter.4;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class bgzy
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements View.OnClickListener, awhd, bgxw
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bafb jdField_a_of_type_Bafb;
  private bgxx jdField_a_of_type_Bgxx;
  public bgya a;
  private bhaf jdField_a_of_type_Bhaf;
  private AEGridView jdField_a_of_type_DovComQqImAECameraPanelMaterialAEGridView;
  public ArrayList<bgya> a;
  private boolean jdField_a_of_type_Boolean;
  
  public bgzy(Context paramContext, AEGridView paramAEGridView, bhaf parambhaf, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Bgxx = ((bgxx)bhfm.a(18));
    this.jdField_a_of_type_Bhaf = parambhaf;
    this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEGridView = paramAEGridView;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private int a(bgya parambgya)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((bgya)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(parambgya.jdField_a_of_type_JavaLangString)) {
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
        if ((paramObject.getId() != null) && (paramObject.getId().equals(((bgya)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))
        {
          ((bgya)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean = paramBoolean;
          notifyItemChanged(i, Integer.valueOf(1));
          return;
        }
        i += 1;
      }
    }
  }
  
  private void b(bgya parambgya)
  {
    if (parambgya == null) {}
    while ((parambgya.e) || (TextUtils.isEmpty(parambgya.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bgxx == null)) {
      return;
    }
    if (!badq.b(this.jdField_a_of_type_AndroidContentContext))
    {
      d(parambgya);
      return;
    }
    c(parambgya);
  }
  
  private void b(bgya parambgya, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (parambgya == null) {}
    label199:
    label204:
    label361:
    for (;;)
    {
      return;
      bhcm.a().b(-1);
      bhcm.a().f("none");
      bhcm.a().e("1");
      bhcm.a().c(0);
      Object localObject;
      if (parambgya != null)
      {
        bhci.a().b(parambgya.jdField_a_of_type_JavaLangString);
        bhcs.a("AEMaterialAdapter", 1, "【Select Material】：" + parambgya.jdField_a_of_type_JavaLangString);
        bhcs.a("AEMaterialAdapter", 1, "【Select Material】Usable :" + parambgya.d);
        if ((parambgya != null) && (!TextUtils.isEmpty(parambgya.jdField_a_of_type_JavaLangString)) && (!bgya.a(parambgya))) {
          break label204;
        }
        if (this.jdField_a_of_type_Bhaf != null) {
          this.jdField_a_of_type_Bhaf.a();
        }
        parambgya = this.jdField_a_of_type_Bgxx;
        localObject = bgya.jdField_a_of_type_Bgya;
        if (this.jdField_a_of_type_Boolean) {
          break label199;
        }
      }
      for (;;)
      {
        parambgya.a((bgya)localObject, bool1);
        QLog.d("AEMaterialAdapter", 4, "### [material panel] select material none");
        return;
        bhci.a().b("null");
        bhcs.a("AEMaterialAdapter", 1, "【Select Material】：null");
        break;
        bool1 = false;
      }
      if (parambgya.a())
      {
        vnd.a(this.jdField_a_of_type_AndroidContentContext, parambgya);
        return;
      }
      if (parambgya.d)
      {
        if (!FeatureManager.isBasicFeaturesFunctionReady())
        {
          bbmy.a(BaseApplicationImpl.getContext(), ajjy.a(2131644033), 0).a();
          ThreadManager.excute(new AEMaterialAdapter.1(this), 64, null, true);
          return;
        }
        if (this.jdField_a_of_type_Bhaf != null) {
          this.jdField_a_of_type_Bhaf.a(parambgya);
        }
        localObject = this.jdField_a_of_type_Bgxx;
        if (!this.jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          ((bgxx)localObject).a(parambgya, bool1);
          QLog.d("AEMaterialAdapter", 4, "### [material panel] select material " + parambgya.jdField_a_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean) {
          break label361;
        }
        this.jdField_a_of_type_Bgxx.a(parambgya);
        return;
        bool1 = false;
        break;
        b(parambgya);
      }
    }
  }
  
  private void c(bgya parambgya)
  {
    if (this.jdField_a_of_type_Bafb == null) {
      this.jdField_a_of_type_Bafb = babr.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(ajjy.a(2131644036)).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131632581)).setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getString(2131629116), new bhaa(this, parambgya)).setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131625035), new bgzz(this));
    }
    try
    {
      if ((this.jdField_a_of_type_Bafb != null) && (!this.jdField_a_of_type_Bafb.isShowing())) {
        this.jdField_a_of_type_Bafb.show();
      }
      return;
    }
    catch (Throwable parambgya) {}
  }
  
  private void d(bgya parambgya)
  {
    this.jdField_a_of_type_Bgxx.a(this.jdField_a_of_type_Bgxx.a(), parambgya, this);
  }
  
  public void a(bgya parambgya)
  {
    b(parambgya, a(parambgya));
  }
  
  public void a(bgya parambgya, int paramInt)
  {
    paramInt = a(parambgya);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.4(this, paramInt));
  }
  
  public void a(bgya parambgya, boolean paramBoolean)
  {
    int i = a(parambgya);
    if (i <= 0) {}
    do
    {
      return;
      ThreadManager.getUIHandler().post(new AEMaterialAdapter.2(this, i, parambgya, paramBoolean));
    } while (paramBoolean);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.3(this));
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 113) {
      if (bgxx.a() != null) {
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
        a(((bgxt)paramVarArgs[0]).a);
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
  
  public void a(List<bgya> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(bgya.jdField_a_of_type_Bgya);
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
    bgya localbgya = (bgya)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localbgya == null) {}
    do
    {
      return;
      if ((paramViewHolder instanceof bhah))
      {
        paramViewHolder = (bhah)paramViewHolder;
        if (localbgya.equals(bgxx.a()))
        {
          paramViewHolder.a();
          return;
        }
        paramViewHolder.b();
        return;
      }
    } while (!(paramViewHolder instanceof bhai));
    paramViewHolder = (bhai)paramViewHolder;
    if ((localbgya.equals(bgxx.a())) && (localbgya.d))
    {
      paramViewHolder.a(2, localbgya);
      return;
    }
    localbgya.jdField_a_of_type_Boolean = false;
    paramViewHolder.a(1, localbgya);
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEGridView.getChildAdapterPosition(paramView);
    if (i == -1) {
      return;
    }
    paramView = (bgya)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    if ((this.jdField_a_of_type_Bgya != null) && (!this.jdField_a_of_type_Bgya.equals(paramView)))
    {
      this.jdField_a_of_type_Bgya.b = false;
      this.jdField_a_of_type_Bgya.c = false;
    }
    this.jdField_a_of_type_Bgya = paramView;
    if (paramView.b) {
      paramView.c = true;
    }
    for (;;)
    {
      b(paramView, i);
      if (paramView.c()) {
        break;
      }
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().putExtra("widgetinfo", "camera^" + paramView.jdField_a_of_type_JavaLangString);
      return;
      paramView.b = true;
    }
    ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().removeExtra("widgetinfo");
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131492948, paramViewGroup, false);
      paramViewGroup = new bhah(localView);
    }
    for (;;)
    {
      localView.setOnClickListener(this);
      return paramViewGroup;
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131492947, paramViewGroup, false);
      paramViewGroup = new bhai(localView);
      paramViewGroup.a(this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgzy
 * JD-Core Version:    0.7.0.1
 */