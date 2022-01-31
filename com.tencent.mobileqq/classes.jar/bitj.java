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
import com.tencent.qphone.base.util.QLog;
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

public class bitj
  extends RecyclerView.Adapter<bitp>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private bito jdField_a_of_type_Bito;
  private bivj jdField_a_of_type_Bivj;
  private bjns jdField_a_of_type_Bjns;
  private HashMap<String, SoftReference<bive>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bita> jdField_a_of_type_JavaUtilList;
  private Set<Integer> jdField_a_of_type_JavaUtilSet;
  
  public bitj(Context paramContext, List<bita> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Int = ((int)(DeviceUtils.getScreenWidth(paramContext) * 0.44F) + 1);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      ((bita)this.jdField_a_of_type_JavaUtilList.get(0)).a(true);
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(0));
    }
  }
  
  private void a(ImageView paramImageView, String paramString, int paramInt)
  {
    Object localObject1 = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localObject1 != null) {}
    for (localObject1 = (bive)((SoftReference)localObject1).get();; localObject1 = null)
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
        localObject1 = new bive(this.jdField_a_of_type_AndroidContentContext, (ArrayList)localObject1, 55L);
        ((bive)localObject1).a(false);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, new SoftReference(localObject1));
      }
      for (paramString = (String)localObject1;; paramString = (String)localObject1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zswp20pro", 2, "playAnimationDrawable, position = " + paramInt);
        }
        if ((paramImageView.getDrawable() != null) && (paramImageView.getDrawable() != paramString) && ((paramImageView.getDrawable() instanceof bive)))
        {
          ((bive)paramImageView.getDrawable()).stop();
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
    if (this.jdField_a_of_type_Bivj != null)
    {
      this.jdField_a_of_type_Bivj.a().a(this.jdField_a_of_type_Bjns, new bitl(this, paramAEGIFOutlineTextView));
      this.jdField_a_of_type_Bivj.b().a(this.jdField_a_of_type_Bjns, new bitm(this, paramAEGIFOutlineTextView));
    }
    paramAEGIFOutlineTextView.setOnClickListener(new bitn(this));
    paramAEGIFOutlineTextView.setVisibility(0);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setEnabled(paramBoolean);
      if (paramBoolean) {
        ((TextView)this.jdField_a_of_type_AndroidViewView).setText(ajya.a(2131699965));
      }
    }
    else
    {
      return;
    }
    ((TextView)this.jdField_a_of_type_AndroidViewView).setText(ajya.a(2131699975));
  }
  
  public bitp a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bitp(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558520, paramViewGroup, false));
  }
  
  public Set<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(bito parambito)
  {
    this.jdField_a_of_type_Bito = parambito;
  }
  
  public void a(bitp parambitp)
  {
    super.onViewRecycled(parambitp);
    if ((bitp.a(parambitp) != null) && (bitp.a(parambitp).getDrawable() != null) && ((bitp.a(parambitp).getDrawable() instanceof bive)))
    {
      ((bive)bitp.a(parambitp).getDrawable()).stop();
      bitp.a(parambitp).setImageDrawable(null);
    }
  }
  
  public void a(bitp parambitp, int paramInt)
  {
    bita localbita = (bita)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837664);
    localObject = bbqz.a("https://qd.myapp.com/myapp/qqteam/QIM/ae_gif_loading.png", new int[] { 0 }, (Drawable)localObject);
    bitp.a(parambitp).setImageDrawable((Drawable)localObject);
    bitp.a(parambitp).setVisibility(4);
    parambitp.a(localbita.a());
    switch (localbita.jdField_a_of_type_Int)
    {
    default: 
    case 10: 
    case 11: 
    case 12: 
      for (;;)
      {
        localObject = parambitp.itemView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = -1;
        ((ViewGroup.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
        parambitp.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        parambitp.itemView.setOnClickListener(new bitk(this, localbita, paramInt, parambitp));
        return;
        bitp.b(parambitp).setVisibility(4);
        bitp.a(parambitp).setVisibility(0);
      }
    }
    bitp.a(parambitp).setVisibility(8);
    if (paramInt == 0)
    {
      a(bitp.a(parambitp));
      bitp.a(parambitp).setVisibility(0);
    }
    bitp.b(parambitp).setVisibility(0);
    if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt)))
    {
      parambitp.a(true);
      a(true);
    }
    for (;;)
    {
      localObject = localbita.c;
      a(bitp.a(parambitp), (String)localObject, paramInt);
      break;
      parambitp.a(false);
    }
  }
  
  public void a(bivj parambivj, bjns parambjns)
  {
    this.jdField_a_of_type_Bivj = parambivj;
    this.jdField_a_of_type_Bjns = parambjns;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bitj
 * JD-Core Version:    0.7.0.1
 */