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
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
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

public class bfvt
  extends bfwg<bfvx, bfur>
{
  protected ColorDrawable a;
  protected String a;
  protected Map<bfuw, Stream<bfuw>> a;
  protected boolean a;
  
  public bfvt(XMediaEditor paramXMediaEditor)
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
  
  private void a(bfuw parambfuw, boolean paramBoolean)
  {
    parambfuw.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getWidth();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() > 0) {
      parambfuw.jdField_d_of_type_Int -= this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() * 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "onItemAdded. editor getWidth result: ", Integer.valueOf(parambfuw.jdField_d_of_type_Int) });
    }
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().notifyDataSetChanged();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.d() == 0) && (parambfuw.b())) {
      a(parambfuw);
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
        break label424;
      }
      if (AlbumUtil.getMediaType((LocalMediaInfo)localHashMap.get(paramIntent)) != 1) {
        break label198;
      }
      j = 1;
    }
    for (;;)
    {
      label163:
      if (j != 0)
      {
        paramIntent = new bfvc(paramIntent);
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
        paramIntent = new bfuw(paramIntent);
      }
      label216:
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, new Object[] { "video selected! size = ", Integer.valueOf(i), ". pic selected! size = ", Integer.valueOf(localArrayList.size() - i) });
      }
      paramIntent = paramXMediaEditor.getContext();
      if (!NetworkUtil.isNetSupport(paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, "no network toast from select media");
        }
        QQToast.a(paramIntent, 2131696954, 0).a();
        return paramBoolean;
      }
      if ((i > 0) && (!NetworkUtil.isWifiConnected(paramIntent)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "no wifi. hasShownNetworkTip=", Boolean.valueOf(paramBoolean) });
        }
        if (!paramBoolean)
        {
          bhdj.a(paramIntent, 230, paramXMediaEditor.getResources().getString(2131695436), paramXMediaEditor.getResources().getString(2131695433), 2131695168, 2131695180, new bfvv(paramXMediaEditor, localArrayList), new bfvw()).show();
          return true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, "insertEditItemList.");
      }
      paramXMediaEditor.a(localArrayList);
      return paramBoolean;
      label424:
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
  
  public bfvx a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new bfvx(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560686, paramViewGroup, false));
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
  
  protected SimpleObserver<bfuw> a(bfuw parambfuw)
  {
    return new bfvu(this, parambfuw);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (!this.jdField_a_of_type_JavaUtilMap.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (bfuw)localIterator.next();
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
    bfuw localbfuw;
    if (paramBoolean) {
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localbfuw = (bfuw)((Iterator)localObject).next();
      } while (localbfuw.g == 2);
    }
    for (;;)
    {
      if (localbfuw != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "scheduleStream. next info position=", Integer.valueOf(localbfuw.c), ", type=", Integer.valueOf(localbfuw.b()), ", hash=", Integer.valueOf(localbfuw.hashCode()) });
        }
        localObject = (Stream)this.jdField_a_of_type_JavaUtilMap.get(localbfuw);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ImageItem", 2, new Object[] { "scheduleStream. fire stream. info hash=", Integer.valueOf(localbfuw.hashCode()) });
          }
          this.jdField_a_of_type_JavaLangString = localbfuw.jdField_d_of_type_JavaLangString;
          this.jdField_a_of_type_Boolean = true;
          localbfuw.jdField_a_of_type_Long = System.currentTimeMillis();
          ((Stream)localObject).subscribe(a(localbfuw));
        }
        return;
        if (((Iterator)localObject).hasNext()) {
          localbfuw = (bfuw)((Iterator)localObject).next();
        }
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      localbfuw = null;
    }
  }
  
  public void a(View paramView, bfvx parambfvx)
  {
    bfuw localbfuw = (bfuw)parambfvx.jdField_a_of_type_Bfur;
    switch (paramView.getId())
    {
    case 2131368267: 
    case 2131368268: 
    default: 
    case 2131368265: 
    case 2131368269: 
      do
      {
        return;
        this.jdField_a_of_type_Bfvo.a(parambfvx);
        return;
      } while (localbfuw.g != 2);
      parambfvx.b.setVisibility(4);
      a(localbfuw);
      return;
    }
    bkxz.a((Activity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "onItemViewClick preview. info position=", Integer.valueOf(localbfuw.c), ", path=", localbfuw.jdField_a_of_type_JavaLangString });
    }
    bfxp.a((BaseActivity)paramView.getContext(), localbfuw.a());
  }
  
  public void a(bfur parambfur)
  {
    parambfur = (bfuw)parambfur;
    if (parambfur.b()) {
      a(parambfur);
    }
  }
  
  protected void a(bfuw parambfuw)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    }
    Stream localStream = parambfuw.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(parambfuw)) {
      this.jdField_a_of_type_JavaUtilMap.put(parambfuw, localStream);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = parambfuw.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_Boolean = true;
      parambfuw.jdField_a_of_type_Long = System.currentTimeMillis();
      localStream.subscribe(a(parambfuw));
    }
  }
  
  public void a(bfvx parambfvx, bfur parambfur, int paramInt)
  {
    if (QLog.isColorLevel()) {
      if (!(parambfur instanceof bfvc)) {
        break label79;
      }
    }
    bfuw localbfuw;
    label79:
    for (Object localObject = "Video";; localObject = "Image")
    {
      QLog.d("ImageItem", 2, new Object[] { localObject, " onBindViewHolder. vh hash=", Integer.valueOf(parambfvx.hashCode()) });
      localbfuw = (bfuw)parambfur;
      if (localbfuw.jdField_d_of_type_Int > 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, "onBindViewHolder maxWidth fail. return");
      }
      return;
    }
    parambfvx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setTag(localbfuw.jdField_d_of_type_JavaLangString);
    int i;
    String str;
    int j;
    if (QLog.isColorLevel())
    {
      i = localbfuw.hashCode();
      str = localbfuw.jdField_d_of_type_JavaLangString;
      j = localbfuw.c;
      if (localbfuw.jdField_a_of_type_JavaNetURL != null) {
        break label499;
      }
      parambfur = "null";
      label138:
      if (parambfvx.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        break label508;
      }
    }
    label499:
    label508:
    for (localObject = "null";; localObject = parambfvx.jdField_a_of_type_ComTencentImageURLDrawable.getURL())
    {
      QLog.d("ImageItem", 2, new Object[] { "onBindViewHolder. VHHash=", parambfvx, ", infoHash=", Integer.valueOf(i), ", progressKey=", str, ", infoPosition=", Integer.valueOf(j), ", info URL=", parambfur, ", vh URL=", localObject, ", showType=", Integer.valueOf(paramInt) });
      parambfur = a(localbfuw.jdField_d_of_type_Int, 200, 300, localbfuw.jdField_a_of_type_Int, localbfuw.b);
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, new Object[] { "onBindViewHolder calculateMaxWidth. infoMaxWidth=", Integer.valueOf(localbfuw.jdField_d_of_type_Int), ", infoWidth=", Integer.valueOf(localbfuw.jdField_a_of_type_Int), ", infoHeight=", Integer.valueOf(localbfuw.b), ", dstWidth=", Integer.valueOf(parambfur[0]), ", dstHeight=", Integer.valueOf(parambfur[1]) });
      }
      a(parambfvx.jdField_a_of_type_AndroidViewView, parambfur[0], parambfur[1]);
      a(parambfvx, localbfuw, paramInt);
      if ((localbfuw.jdField_a_of_type_JavaNetURL == null) || (localbfuw.g == -2147483645)) {
        break label520;
      }
      localObject = parambfvx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getDrawable();
      if (((localObject instanceof URLDrawable)) && (localbfuw.jdField_a_of_type_JavaNetURL.equals(((URLDrawable)localObject).getURL()))) {
        break;
      }
      parambfur = URLDrawable.getDrawable(localbfuw.jdField_a_of_type_JavaNetURL, parambfur[0], parambfur[1], this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      parambfvx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable(parambfur);
      if (parambfur.getStatus() != 2) {
        break;
      }
      parambfur.restartDownload();
      return;
      parambfur = localbfuw.jdField_a_of_type_JavaNetURL;
      break label138;
    }
    label520:
    parambfvx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
  }
  
  protected <VH extends bfvx, INFO extends bfuw> void a(VH paramVH, INFO paramINFO, int paramInt)
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
  
  public void b(bfur parambfur)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getWidth();
    if (i <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, new Object[] { "onItemAdded. editor getWidth fail result: ", Integer.valueOf(i) });
      }
      ThreadManager.getUIHandler().postDelayed(new ImageItem.1(this, parambfur), 50L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "onItemAdded. editor getWidth result without post: ", Integer.valueOf(i) });
    }
    a((bfuw)parambfur, false);
  }
  
  public void d(bfur parambfur)
  {
    parambfur = (bfuw)parambfur;
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (!this.jdField_a_of_type_JavaUtilMap.isEmpty()))
    {
      Stream localStream = (Stream)this.jdField_a_of_type_JavaUtilMap.get(parambfur);
      if (localStream != null) {
        localStream.cancel();
      }
    }
    if (parambfur.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      parambfur.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if (parambfur.jdField_a_of_type_JavaNetURL != null) {
      URLDrawable.removeMemoryCacheByUrl(parambfur.jdField_a_of_type_JavaNetURL.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfvt
 * JD-Core Version:    0.7.0.1
 */