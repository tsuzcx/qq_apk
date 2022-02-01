package com.tencent.aelight.camera.aeeditor.module.edit;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import androidx.lifecycle.ViewModel;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorDataServiceHandler;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/aeeditor/module/edit/AEVideoEditViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "AUTO_TEMPLATE_KEY_FRAME_COUNT", "", "MAX_SAMPLE_SIZE", "autoTemplateRequested", "", "recommendFrameCacheList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/graphics/Bitmap;", "tavCutVideoSession", "Lcom/tencent/tavcut/session/TAVCutVideoSession;", "getTavCutVideoSession", "()Lcom/tencent/tavcut/session/TAVCutVideoSession;", "setTavCutVideoSession", "(Lcom/tencent/tavcut/session/TAVCutVideoSession;)V", "createFrameByteList", "Ljava/util/ArrayList;", "", "bitmaps", "", "requestAutoTemplate", "", "requestAutoTemplateFromPic", "pics", "", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEVideoEditViewModel
  extends ViewModel
{
  private final int jdField_a_of_type_Int = 6;
  @Nullable
  private TAVCutVideoSession jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
  private CopyOnWriteArrayList<Bitmap> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private boolean jdField_a_of_type_Boolean;
  private final int b = 240;
  
  private final ArrayList<byte[]> a(List<Bitmap> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    double d1 = 102400.0F / this.jdField_a_of_type_Int;
    double d2 = paramList.size();
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 = Math.sqrt(d1 / d2);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      int i = 0;
      if (localBitmap != null)
      {
        if (localBitmap.getWidth() <= d1)
        {
          paramList = localBitmap;
          if (localBitmap.getHeight() <= d1) {}
        }
        else
        {
          paramList = new Matrix();
          d2 = localBitmap.getWidth();
          Double.isNaN(d2);
          d2 = d1 / d2;
          double d3 = localBitmap.getHeight();
          Double.isNaN(d3);
          float f = (float)RangesKt.coerceAtLeast(d2, d1 / d3);
          paramList.postScale(f, f);
          paramList = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramList, true);
          Intrinsics.checkExpressionValueIsNotNull(paramList, "Bitmap.createBitmap(bitm…map.height, matrix, true)");
          i = 1;
        }
        paramList.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localByteArrayOutputStream);
        localArrayList.add(localByteArrayOutputStream.toByteArray());
        try
        {
          localByteArrayOutputStream.close();
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
        if (i != 0) {
          BitmapUtils.recycle(paramList);
        }
      }
    }
    return localArrayList;
  }
  
  public final void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
    int n = 2;
    int i = n;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (List)new ArrayList();
      Object localObject3 = ((TAVCutVideoSession)localObject1).getDuration();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "session.duration");
      long l1 = ((CMTime)localObject3).getTimeUs();
      long l2 = 1000;
      int j = this.jdField_a_of_type_Int;
      if (1 <= j)
      {
        i = 1;
        for (;;)
        {
          ((List)localObject2).add(Long.valueOf(l1 * l2 / (this.jdField_a_of_type_Int + 1) * i));
          if (i == j) {
            break;
          }
          i += 1;
        }
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null)
      {
        localObject3 = (AEVideoEditViewModel)this;
        localObject2 = ((TAVCutVideoSession)localObject1).getMultiVideoFrame((List)localObject2, 250);
        if (localObject2 != null)
        {
          if (((List)localObject2).isEmpty()) {
            return;
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList((Collection)localObject2);
          localObject2 = Unit.INSTANCE;
        }
      }
      else
      {
        i = ((TAVCutVideoSession)localObject1).getMediaModel().getMediaResourceModel().getVideos().size();
        j = 0;
        int i1;
        if (i == 1) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        localObject1 = ((TAVCutVideoSession)localObject1).getMediaModel().getMediaResourceModel().getVideos().iterator();
        i = 0;
        int k;
        int m;
        do
        {
          do
          {
            k = j;
            m = i;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            if (((MediaClipModel)((Iterator)localObject1).next()).getResource().getType() == 1)
            {
              k = 1;
              m = i;
            }
            else
            {
              m = 1;
              k = j;
            }
            j = k;
            i = m;
          } while (k == 0);
          j = k;
          i = m;
        } while (m == 0);
        if ((k != 0) && (m != 0))
        {
          i = 5;
          break label355;
        }
        i = n;
        if (k != 0) {
          if (i1 != 0) {
            i = n;
          } else {
            i = 4;
          }
        }
        if (m == 0) {
          break label355;
        }
        if (i1 != 0) {
          i = 1;
        } else {
          i = 3;
        }
        break label355;
      }
      return;
    }
    label355:
    localObject1 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if (localObject1 != null)
    {
      localObject1 = a((List)localObject1);
      localObject2 = QQStoryContext.a().getBusinessHandler(PeakAppInterface.e);
      if (localObject2 != null)
      {
        localObject2 = (AEEditorDataServiceHandler)localObject2;
        if (!this.jdField_a_of_type_Boolean)
        {
          ((AEEditorDataServiceHandler)localObject2).a("MqCircleEditor", (ArrayList)localObject1, i);
          this.jdField_a_of_type_Boolean = true;
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.aelight.camera.aeeditor.manage.AEEditorDataServiceHandler");
      }
    }
  }
  
  public final void a(@Nullable TAVCutVideoSession paramTAVCutVideoSession)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = paramTAVCutVideoSession;
  }
  
  public final void a(@NotNull List<String> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "pics");
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject1 = (List)new ArrayList();
    int j = paramList.size();
    int k = this.jdField_a_of_type_Int;
    int i;
    if (1 <= k)
    {
      i = 1;
      for (;;)
      {
        ((List)localObject1).add(Integer.valueOf(j * 100 / (this.jdField_a_of_type_Int + 1) * i / 100));
        if (i == k) {
          break;
        }
        i += 1;
      }
    }
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null)
    {
      localObject2 = (AEVideoEditViewModel)this;
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        j = ((Number)((Iterator)localObject2).next()).intValue();
        Object localObject3 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
        BitmapFactory.decodeFile((String)paramList.get(j), (BitmapFactory.Options)localObject3);
        i = RangesKt.coerceAtLeast(((BitmapFactory.Options)localObject3).outWidth, ((BitmapFactory.Options)localObject3).outHeight);
        k = this.b;
        if (i > k) {
          i /= k;
        } else {
          i = 1;
        }
        localObject3 = (String)paramList.get(j);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inSampleSize = i;
        ((Collection)localObject1).add(BitmapFactory.decodeFile((String)localObject3, localOptions));
      }
      localObject1 = (List)localObject1;
      if (((List)localObject1).isEmpty()) {
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList((Collection)localObject1);
      localObject1 = Unit.INSTANCE;
    }
    localObject1 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if (localObject1 != null)
    {
      localObject1 = a((List)localObject1);
      localObject2 = QQStoryContext.a().getBusinessHandler(PeakAppInterface.e);
      if (localObject2 != null)
      {
        localObject2 = (AEEditorDataServiceHandler)localObject2;
        if (!this.jdField_a_of_type_Boolean)
        {
          if (paramList.size() <= 1) {
            i = 1;
          } else {
            i = 3;
          }
          ((AEEditorDataServiceHandler)localObject2).a("MqCircleEditor", (ArrayList)localObject1, i);
          this.jdField_a_of_type_Boolean = true;
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.aelight.camera.aeeditor.manage.AEEditorDataServiceHandler");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEVideoEditViewModel
 * JD-Core Version:    0.7.0.1
 */