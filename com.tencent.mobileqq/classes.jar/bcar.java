import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem.1;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class bcar
  extends bcbe<bcav, bbzp>
{
  protected ColorDrawable a;
  protected String a;
  protected Map<bbzu, Stream<bbzu>> a;
  protected boolean a;
  
  public bcar(XMediaEditor paramXMediaEditor)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#DEDEDE"));
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((paramView != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      paramInt1 = paramView.getPaddingLeft() + paramView.getPaddingRight() + paramInt1;
      paramInt2 = paramView.getPaddingTop() + paramView.getPaddingBottom() + paramInt2;
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      if (localLayoutParams == null) {
        break label77;
      }
      if ((localLayoutParams.width != paramInt1) || (localLayoutParams.height != paramInt2))
      {
        localLayoutParams.width = paramInt1;
        localLayoutParams.height = paramInt2;
        paramView.setLayoutParams(localLayoutParams);
      }
    }
    return;
    label77:
    paramView.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
  }
  
  private void a(bbzu parambbzu, boolean paramBoolean)
  {
    parambbzu.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getWidth();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() > 0) {
      parambbzu.jdField_d_of_type_Int -= this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() * 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "onItemAdded. editor getWidth result: ", Integer.valueOf(parambbzu.jdField_d_of_type_Int) });
    }
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().notifyDataSetChanged();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.d() == 0) && (parambbzu.b())) {
      a(parambbzu);
    }
  }
  
  public static boolean a(XMediaEditor paramXMediaEditor, Intent paramIntent, boolean paramBoolean)
  {
    if (paramIntent != null) {}
    for (Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"); (localObject == null) || (((ArrayList)localObject).size() == 0); localObject = null)
    {
      QLog.e("ImageItem", 1, "selected list empty!");
      return paramBoolean;
    }
    HashMap localHashMap = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    int i;
    ArrayList localArrayList;
    label116:
    int j;
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder().append("selected pic or video! size = ");
      if (localHashMap != null)
      {
        i = localHashMap.size();
        QLog.d("ImageItem", 2, i);
      }
    }
    else
    {
      localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      i = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label216;
      }
      paramIntent = (String)((Iterator)localObject).next();
      if (localHashMap == null) {
        break label423;
      }
      if (bdar.getMediaType((LocalMediaInfo)localHashMap.get(paramIntent)) != 1) {
        break label198;
      }
      j = 1;
    }
    for (;;)
    {
      label163:
      if (j != 0)
      {
        paramIntent = new bcaa(paramIntent);
        i += 1;
      }
      for (;;)
      {
        localArrayList.add(paramIntent);
        break label116;
        i = 0;
        break;
        label198:
        j = 0;
        break label163;
        paramIntent = new bbzu(paramIntent);
      }
      label216:
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, new Object[] { "video selected! size = ", Integer.valueOf(i), ". pic selected! size = ", Integer.valueOf(localArrayList.size() - i) });
      }
      paramIntent = paramXMediaEditor.getContext();
      if (!bdee.d(paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, "no network toast from select media");
        }
        QQToast.a(paramIntent, 2131697659, 0).a();
        return paramBoolean;
      }
      if ((i > 0) && (!bdee.h(paramIntent)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "no wifi. hasShownNetworkTip=", Boolean.valueOf(paramBoolean) });
        }
        if (!paramBoolean)
        {
          bdcd.a(paramIntent, 230, paramXMediaEditor.getResources().getString(2131696156), paramXMediaEditor.getResources().getString(2131696153), 2131695892, 2131695904, new bcat(paramXMediaEditor, localArrayList), new bcau()).show();
          return true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, "insertEditItemList.");
      }
      paramXMediaEditor.a(localArrayList);
      return paramBoolean;
      label423:
      j = 0;
    }
  }
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = paramInt4;
    arrayOfInt[1] = paramInt5;
    if ((paramInt4 > 0) && (paramInt5 > 0)) {
      if (paramInt4 > paramInt3)
      {
        arrayOfInt[0] = paramInt1;
        arrayOfInt[1] = ((int)(paramInt1 * 1.0F * paramInt5 / paramInt4));
      }
    }
    do
    {
      do
      {
        return arrayOfInt;
      } while (Math.min(paramInt4, paramInt5) >= paramInt2);
      if (paramInt4 <= paramInt5)
      {
        arrayOfInt[0] = paramInt2;
        arrayOfInt[1] = ((int)(paramInt2 * 1.0F * paramInt5 / paramInt4));
        return arrayOfInt;
      }
      arrayOfInt[0] = ((int)(paramInt2 * 1.0F * paramInt4 / paramInt5));
      arrayOfInt[1] = paramInt2;
      return arrayOfInt;
      arrayOfInt[0] = paramInt1;
      arrayOfInt[1] = ((int)(paramInt1 * 9 / 16.0F));
    } while (!QLog.isColorLevel());
    QLog.d("ImageItem", 2, new Object[] { "calculateMaxMinImageSize doudi. maxWidth=", Integer.valueOf(arrayOfInt[0]), ", height=", Integer.valueOf(arrayOfInt[1]) });
    return arrayOfInt;
  }
  
  public bcav a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new bcav(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560454, paramViewGroup, false));
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "Image onCreateViewHolder. vh hash=", Integer.valueOf(paramViewGroup.hashCode()) });
    }
    b(paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, paramViewGroup);
    b(paramViewGroup.jdField_a_of_type_AndroidWidgetImageView, paramViewGroup);
    b(paramViewGroup.b, paramViewGroup);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) {
      paramViewGroup.itemView.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    return paramViewGroup;
  }
  
  protected SimpleObserver<bbzu> a(bbzu parambbzu)
  {
    return new bcas(this, parambbzu);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (!this.jdField_a_of_type_JavaUtilMap.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (bbzu)localIterator.next();
        localObject = (Stream)this.jdField_a_of_type_JavaUtilMap.get(localObject);
        if (localObject != null) {
          ((Stream)localObject).cancel();
        }
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "scheduleStream. hasNext=", Boolean.valueOf(((Iterator)localObject).hasNext()) });
    }
    bbzu localbbzu;
    if (paramBoolean) {
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localbbzu = (bbzu)((Iterator)localObject).next();
      } while (localbbzu.g == 2);
    }
    for (;;)
    {
      if (localbbzu != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "scheduleStream. next info position=", Integer.valueOf(localbbzu.c), ", type=", Integer.valueOf(localbbzu.b()), ", hash=", Integer.valueOf(localbbzu.hashCode()) });
        }
        localObject = (Stream)this.jdField_a_of_type_JavaUtilMap.get(localbbzu);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ImageItem", 2, new Object[] { "scheduleStream. fire stream. info hash=", Integer.valueOf(localbbzu.hashCode()) });
          }
          this.jdField_a_of_type_JavaLangString = localbbzu.jdField_d_of_type_JavaLangString;
          this.jdField_a_of_type_Boolean = true;
          localbbzu.jdField_a_of_type_Long = System.currentTimeMillis();
          ((Stream)localObject).subscribe(a(localbbzu));
        }
        return;
        if (((Iterator)localObject).hasNext()) {
          localbbzu = (bbzu)((Iterator)localObject).next();
        }
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      localbbzu = null;
    }
  }
  
  public void a(View paramView, bcav parambcav)
  {
    bbzu localbbzu = (bbzu)parambcav.jdField_a_of_type_Bbzp;
    switch (paramView.getId())
    {
    case 2131367699: 
    case 2131367700: 
    default: 
    case 2131367697: 
    case 2131367701: 
      do
      {
        return;
        this.jdField_a_of_type_Bcam.a(parambcav);
        return;
      } while (localbbzu.g != 2);
      parambcav.b.setVisibility(4);
      a(localbbzu);
      return;
    }
    bhoc.a((Activity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "onItemViewClick preview. info position=", Integer.valueOf(localbbzu.c), ", path=", localbbzu.jdField_a_of_type_JavaLangString });
    }
    bcch.a((BaseActivity)paramView.getContext(), localbbzu.a());
  }
  
  public void a(bbzp parambbzp)
  {
    parambbzp = (bbzu)parambbzp;
    if (parambbzp.b()) {
      a(parambbzp);
    }
  }
  
  protected void a(bbzu parambbzu)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    }
    Stream localStream = parambbzu.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(parambbzu)) {
      this.jdField_a_of_type_JavaUtilMap.put(parambbzu, localStream);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = parambbzu.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_Boolean = true;
      parambbzu.jdField_a_of_type_Long = System.currentTimeMillis();
      localStream.subscribe(a(parambbzu));
    }
  }
  
  public void a(bcav parambcav, bbzp parambbzp, int paramInt)
  {
    if (QLog.isColorLevel()) {
      if (!(parambbzp instanceof bcaa)) {
        break label79;
      }
    }
    bbzu localbbzu;
    label79:
    for (Object localObject = "Video";; localObject = "Image")
    {
      QLog.d("ImageItem", 2, new Object[] { localObject, " onBindViewHolder. vh hash=", Integer.valueOf(parambcav.hashCode()) });
      localbbzu = (bbzu)parambbzp;
      if (localbbzu.jdField_d_of_type_Int > 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, "onBindViewHolder maxWidth fail. return");
      }
      return;
    }
    parambcav.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setTag(localbbzu.jdField_d_of_type_JavaLangString);
    int i;
    String str;
    int j;
    if (QLog.isColorLevel())
    {
      i = localbbzu.hashCode();
      str = localbbzu.jdField_d_of_type_JavaLangString;
      j = localbbzu.c;
      if (localbbzu.jdField_a_of_type_JavaNetURL != null) {
        break label499;
      }
      parambbzp = "null";
      label138:
      if (parambcav.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        break label508;
      }
    }
    label499:
    label508:
    for (localObject = "null";; localObject = parambcav.jdField_a_of_type_ComTencentImageURLDrawable.getURL())
    {
      QLog.d("ImageItem", 2, new Object[] { "onBindViewHolder. VHHash=", parambcav, ", infoHash=", Integer.valueOf(i), ", progressKey=", str, ", infoPosition=", Integer.valueOf(j), ", info URL=", parambbzp, ", vh URL=", localObject, ", showType=", Integer.valueOf(paramInt) });
      parambbzp = a(localbbzu.jdField_d_of_type_Int, 200, 300, localbbzu.jdField_a_of_type_Int, localbbzu.b);
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, new Object[] { "onBindViewHolder calculateMaxWidth. infoMaxWidth=", Integer.valueOf(localbbzu.jdField_d_of_type_Int), ", infoWidth=", Integer.valueOf(localbbzu.jdField_a_of_type_Int), ", infoHeight=", Integer.valueOf(localbbzu.b), ", dstWidth=", Integer.valueOf(parambbzp[0]), ", dstHeight=", Integer.valueOf(parambbzp[1]) });
      }
      a(parambcav.jdField_a_of_type_AndroidViewView, parambbzp[0], parambbzp[1]);
      a(parambcav, localbbzu, paramInt);
      if ((localbbzu.jdField_a_of_type_JavaNetURL == null) || (localbbzu.g == -2147483645)) {
        break label520;
      }
      localObject = parambcav.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getDrawable();
      if (((localObject instanceof URLDrawable)) && (localbbzu.jdField_a_of_type_JavaNetURL.equals(((URLDrawable)localObject).getURL()))) {
        break;
      }
      parambbzp = URLDrawable.getDrawable(localbbzu.jdField_a_of_type_JavaNetURL, parambbzp[0], parambbzp[1], this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      parambcav.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable(parambbzp);
      if (parambbzp.getStatus() != 2) {
        break;
      }
      parambbzp.restartDownload();
      return;
      parambbzp = localbbzu.jdField_a_of_type_JavaNetURL;
      break label138;
    }
    label520:
    parambcav.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
  }
  
  protected <VH extends bcav, INFO extends bbzu> void a(VH paramVH, INFO paramINFO, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramVH.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      paramVH.b.setVisibility(4);
      paramVH.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    }
    do
    {
      return;
      paramVH.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      switch (paramINFO.g)
      {
      default: 
        return;
      case 1: 
        paramVH.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
        paramVH.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        paramVH.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramINFO.e, paramINFO.jdField_d_of_type_JavaLangString);
        paramVH.b.setVisibility(4);
        return;
      case 2: 
        paramVH.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
        paramVH.b.setVisibility(0);
        return;
      }
    } while (paramINFO.e != 100);
    paramVH.a();
  }
  
  public void b(bbzp parambbzp)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getWidth();
    if (i <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, new Object[] { "onItemAdded. editor getWidth fail result: ", Integer.valueOf(i) });
      }
      ThreadManager.getUIHandler().postDelayed(new ImageItem.1(this, parambbzp), 50L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "onItemAdded. editor getWidth result without post: ", Integer.valueOf(i) });
    }
    a((bbzu)parambbzp, false);
  }
  
  public void d(bbzp parambbzp)
  {
    parambbzp = (bbzu)parambbzp;
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (!this.jdField_a_of_type_JavaUtilMap.isEmpty()))
    {
      Stream localStream = (Stream)this.jdField_a_of_type_JavaUtilMap.get(parambbzp);
      if (localStream != null) {
        localStream.cancel();
      }
    }
    if (parambbzp.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      parambbzp.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if (parambbzp.jdField_a_of_type_JavaNetURL != null) {
      URLDrawable.removeMemoryCacheByUrl(parambbzp.jdField_a_of_type_JavaNetURL.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcar
 * JD-Core Version:    0.7.0.1
 */