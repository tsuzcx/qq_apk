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

public class botf
  extends RecyclerView.Adapter<botl>
{
  private int jdField_a_of_type_Int;
  private LifecycleOwner jdField_a_of_type_AndroidArchLifecycleLifecycleOwner;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private botk jdField_a_of_type_Botk;
  private bove jdField_a_of_type_Bove;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, SoftReference<bova>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bosw> jdField_a_of_type_JavaUtilList;
  private Set<Integer> jdField_a_of_type_JavaUtilSet;
  
  public botf(Context paramContext, List<bosw> paramList, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Int = ((int)(DeviceUtils.getScreenWidth(paramContext) * 0.44F) + 1);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      ((bosw)this.jdField_a_of_type_JavaUtilList.get(0)).a(true);
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(0));
    }
  }
  
  private void a(ImageView paramImageView, String paramString, int paramInt)
  {
    Object localObject1 = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localObject1 != null) {}
    for (localObject1 = (bova)((SoftReference)localObject1).get();; localObject1 = null)
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
        localObject1 = new bova(this.jdField_a_of_type_AndroidContentContext, (ArrayList)localObject1, 55L);
        ((bova)localObject1).a(false);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, new SoftReference(localObject1));
      }
      for (paramString = (String)localObject1;; paramString = (String)localObject1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zswp20pro", 2, "playAnimationDrawable, position = " + paramInt);
        }
        if ((paramImageView.getDrawable() != null) && (paramImageView.getDrawable() != paramString) && ((paramImageView.getDrawable() instanceof bova)))
        {
          ((bova)paramImageView.getDrawable()).stop();
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
    if (this.jdField_a_of_type_Bove != null)
    {
      this.jdField_a_of_type_Bove.a().observe(this.jdField_a_of_type_AndroidArchLifecycleLifecycleOwner, new both(this, paramAEGIFOutlineTextView));
      this.jdField_a_of_type_Bove.b().observe(this.jdField_a_of_type_AndroidArchLifecycleLifecycleOwner, new boti(this, paramAEGIFOutlineTextView));
    }
    paramAEGIFOutlineTextView.setOnClickListener(new botj(this));
    paramAEGIFOutlineTextView.setVisibility(0);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setEnabled(paramBoolean);
      if (paramBoolean) {
        ((TextView)this.jdField_a_of_type_AndroidViewView).setText(anzj.a(2131698879));
      }
    }
    else
    {
      return;
    }
    ((TextView)this.jdField_a_of_type_AndroidViewView).setText(anzj.a(2131698889));
  }
  
  public botl a(ViewGroup paramViewGroup, int paramInt)
  {
    return new botl(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558573, paramViewGroup, false), this.jdField_a_of_type_JavaLangString);
  }
  
  public Set<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(botk parambotk)
  {
    this.jdField_a_of_type_Botk = parambotk;
  }
  
  public void a(botl parambotl)
  {
    super.onViewRecycled(parambotl);
    if ((botl.a(parambotl) != null) && (botl.a(parambotl).getDrawable() != null) && ((botl.a(parambotl).getDrawable() instanceof bova)))
    {
      ((bova)botl.a(parambotl).getDrawable()).stop();
      botl.a(parambotl).setImageDrawable(null);
    }
  }
  
  public void a(botl parambotl, int paramInt)
  {
    bosw localbosw = (bosw)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837954);
    localObject = VasApngUtil.getApngURLDrawable("https://qd.myapp.com/myapp/qqteam/QIM/ae_gif_loading.png", new int[] { 0 }, (Drawable)localObject);
    botl.a(parambotl).setImageDrawable((Drawable)localObject);
    botl.a(parambotl).setVisibility(4);
    parambotl.a(localbosw.a());
    switch (localbosw.jdField_a_of_type_Int)
    {
    default: 
    case 10: 
    case 11: 
    case 12: 
      for (;;)
      {
        localObject = parambotl.itemView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = -1;
        ((ViewGroup.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
        parambotl.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        parambotl.itemView.setOnClickListener(new botg(this, localbosw, paramInt, parambotl));
        EventCollector.getInstance().onRecyclerBindViewHolder(parambotl, paramInt, getItemId(paramInt));
        return;
        botl.b(parambotl).setVisibility(4);
        botl.a(parambotl).setVisibility(0);
      }
    }
    botl.a(parambotl).setVisibility(8);
    if (paramInt == 0)
    {
      a(botl.a(parambotl));
      botl.a(parambotl).setVisibility(0);
    }
    botl.b(parambotl).setVisibility(0);
    if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt)))
    {
      parambotl.a(true);
      a(true);
    }
    for (;;)
    {
      localObject = localbosw.c;
      a(botl.a(parambotl), (String)localObject, paramInt);
      break;
      parambotl.a(false);
    }
  }
  
  public void a(bove parambove, LifecycleOwner paramLifecycleOwner)
  {
    this.jdField_a_of_type_Bove = parambove;
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
 * Qualified Name:     botf
 * JD-Core Version:    0.7.0.1
 */