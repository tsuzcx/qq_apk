import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;
import dov.com.qq.im.ae.gif.giftext.DrawableImageView;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class blxk
  extends RecyclerView.Adapter<blxq>
{
  private int jdField_a_of_type_Int;
  private LifecycleOwner jdField_a_of_type_AndroidArchLifecycleLifecycleOwner;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private blxp jdField_a_of_type_Blxp;
  private blzj jdField_a_of_type_Blzj;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, SoftReference<blzf>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<blxb> jdField_a_of_type_JavaUtilList;
  private Set<Integer> jdField_a_of_type_JavaUtilSet;
  
  public blxk(Context paramContext, List<blxb> paramList, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Int = ((int)(DeviceUtils.getScreenWidth(paramContext) * 0.44F) + 1);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      ((blxb)this.jdField_a_of_type_JavaUtilList.get(0)).a(true);
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(0));
    }
  }
  
  private void a(ImageView paramImageView, String paramString, int paramInt)
  {
    Object localObject1 = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localObject1 != null) {}
    for (localObject1 = (blzf)((SoftReference)localObject1).get();; localObject1 = null)
    {
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        if (!TextUtils.isEmpty(paramString))
        {
          Object localObject2 = new File(paramString);
          if (((File)localObject2).exists())
          {
            localObject2 = ((File)localObject2).listFiles();
            if (localObject2.length > 0)
            {
              int i = 0;
              while (i < localObject2.length)
              {
                String str = String.format(paramString + "/frame_%03d.png", new Object[] { Integer.valueOf(i) });
                if (new File(str).exists()) {
                  ((ArrayList)localObject1).add(str);
                }
                i += 1;
              }
            }
          }
        }
        localObject1 = new blzf(this.jdField_a_of_type_AndroidContentContext, (ArrayList)localObject1, 55L);
        ((blzf)localObject1).a(false);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, new SoftReference(localObject1));
      }
      for (paramString = (String)localObject1;; paramString = (String)localObject1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zswp20pro", 2, "playAnimationDrawable, position = " + paramInt);
        }
        if ((paramImageView.getDrawable() != null) && (paramImageView.getDrawable() != paramString) && ((paramImageView.getDrawable() instanceof blzf)))
        {
          ((blzf)paramImageView.getDrawable()).stop();
          paramImageView.setImageDrawable(null);
        }
        paramImageView.setImageDrawable(paramString);
        paramString.start();
        return;
      }
    }
  }
  
  private void a(AEGIFOutlineTextView paramAEGIFOutlineTextView)
  {
    if (this.jdField_a_of_type_Blzj != null)
    {
      this.jdField_a_of_type_Blzj.a().observe(this.jdField_a_of_type_AndroidArchLifecycleLifecycleOwner, new blxm(this, paramAEGIFOutlineTextView));
      this.jdField_a_of_type_Blzj.b().observe(this.jdField_a_of_type_AndroidArchLifecycleLifecycleOwner, new blxn(this, paramAEGIFOutlineTextView));
    }
    paramAEGIFOutlineTextView.setOnClickListener(new blxo(this));
    paramAEGIFOutlineTextView.setVisibility(0);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setEnabled(paramBoolean);
      if (paramBoolean) {
        ((TextView)this.jdField_a_of_type_AndroidViewView).setText(amtj.a(2131699114));
      }
    }
    else
    {
      return;
    }
    ((TextView)this.jdField_a_of_type_AndroidViewView).setText(amtj.a(2131699124));
  }
  
  public blxq a(ViewGroup paramViewGroup, int paramInt)
  {
    return new blxq(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558576, paramViewGroup, false), this.jdField_a_of_type_JavaLangString);
  }
  
  public Set<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(blxp paramblxp)
  {
    this.jdField_a_of_type_Blxp = paramblxp;
  }
  
  public void a(blxq paramblxq)
  {
    super.onViewRecycled(paramblxq);
    if ((blxq.a(paramblxq) != null) && (blxq.a(paramblxq).getDrawable() != null) && ((blxq.a(paramblxq).getDrawable() instanceof blzf)))
    {
      ((blzf)blxq.a(paramblxq).getDrawable()).stop();
      blxq.a(paramblxq).setImageDrawable(null);
    }
  }
  
  public void a(blxq paramblxq, int paramInt)
  {
    blxb localblxb = (blxb)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837979);
    localObject = VasApngUtil.getApngURLDrawable("https://qd.myapp.com/myapp/qqteam/QIM/ae_gif_loading.png", new int[] { 0 }, (Drawable)localObject);
    blxq.a(paramblxq).setImageDrawable((Drawable)localObject);
    blxq.a(paramblxq).setVisibility(4);
    paramblxq.a(localblxb.a());
    switch (localblxb.jdField_a_of_type_Int)
    {
    default: 
    case 10: 
    case 11: 
    case 12: 
      for (;;)
      {
        localObject = paramblxq.itemView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = -1;
        ((ViewGroup.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
        paramblxq.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramblxq.itemView.setOnClickListener(new blxl(this, localblxb, paramInt, paramblxq));
        EventCollector.getInstance().onRecyclerBindViewHolder(paramblxq, paramInt, getItemId(paramInt));
        return;
        blxq.b(paramblxq).setVisibility(4);
        blxq.a(paramblxq).setVisibility(0);
      }
    }
    blxq.a(paramblxq).setVisibility(8);
    if (paramInt == 0)
    {
      a(blxq.a(paramblxq));
      blxq.a(paramblxq).setVisibility(0);
    }
    blxq.b(paramblxq).setVisibility(0);
    if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt)))
    {
      paramblxq.a(true);
      a(true);
    }
    for (;;)
    {
      localObject = localblxb.c;
      a(blxq.a(paramblxq), (String)localObject, paramInt);
      break;
      paramblxq.a(false);
    }
  }
  
  public void a(blzj paramblzj, LifecycleOwner paramLifecycleOwner)
  {
    this.jdField_a_of_type_Blzj = paramblzj;
    this.jdField_a_of_type_AndroidArchLifecycleLifecycleOwner = paramLifecycleOwner;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxk
 * JD-Core Version:    0.7.0.1
 */