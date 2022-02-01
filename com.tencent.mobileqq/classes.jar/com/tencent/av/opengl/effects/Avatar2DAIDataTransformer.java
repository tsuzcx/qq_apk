package com.tencent.av.opengl.effects;

import android.graphics.PointF;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.light.bean.Light3DMMData;
import org.light.bean.Light3DMMFeature;
import org.light.bean.LightAIClassifier;
import org.light.bean.LightAIData;
import org.light.bean.LightAIDataWrapper;
import org.light.bean.LightAIKeyPoint;
import org.light.bean.LightFaceData;
import org.light.bean.LightFaceFeature;
import trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.AIClassifier;
import trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.AIExpression;
import trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.AIKeyPoint;
import trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.Avatar2DAIData;
import trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.Avatar2DAIDataMap;
import trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.Avatar2DAIDataWrapper;
import trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.AvatarAI3DMMData;
import trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.AvatarAI3DMMFeature;
import trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.AvatarAIFaceData;
import trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.AvatarAIFaceFeature;
import trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.Matrix4;
import trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.Point;
import trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.Rect;
import trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.Size;

public class Avatar2DAIDataTransformer
{
  private static final String[] a = { "HAND_AGENT", "GY_BODY_AGENT", "EMOTION_AGENT" };
  
  private static List<Avatar2DLightAIData.AIKeyPoint> a(List<LightAIKeyPoint> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (LightAIKeyPoint)paramList.next();
        Avatar2DLightAIData.AIKeyPoint localAIKeyPoint = new Avatar2DLightAIData.AIKeyPoint();
        localAIKeyPoint.uint32_trace_id.set(((LightAIKeyPoint)localObject).getTraceId());
        if ((((LightAIKeyPoint)localObject).getAiPoints() != null) && (((LightAIKeyPoint)localObject).getAiPoints().length > 0))
        {
          ArrayList localArrayList2 = new ArrayList();
          localObject = ((LightAIKeyPoint)localObject).getAiPoints();
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localArrayList2.add(Float.valueOf(localObject[i]));
            i += 1;
          }
          localAIKeyPoint.float_keypoint.set(localArrayList2);
        }
        localArrayList1.add(localAIKeyPoint);
      }
    }
    return localArrayList1;
  }
  
  private static LightAIData a(Avatar2DLightAIData.Avatar2DAIData paramAvatar2DAIData)
  {
    ArrayList localArrayList1 = new ArrayList();
    LightFaceData localLightFaceData = new LightFaceData();
    if (paramAvatar2DAIData.ai_face_data.has())
    {
      paramAvatar2DAIData = (Avatar2DLightAIData.AvatarAIFaceData)paramAvatar2DAIData.ai_face_data.get();
      if (paramAvatar2DAIData.face_feature.has())
      {
        ArrayList localArrayList2 = new ArrayList();
        Iterator localIterator = paramAvatar2DAIData.face_feature.get().iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (Avatar2DLightAIData.AvatarAIFaceFeature)localIterator.next();
          LightFaceFeature localLightFaceFeature = new LightFaceFeature();
          if (((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).bool_has_outline.has()) {
            localLightFaceFeature.hasOutline = ((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).bool_has_outline.get();
          }
          if (((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).str_gender.has()) {
            localLightFaceFeature.gender = ((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).str_gender.get();
          }
          if (((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).str_emotion.has()) {
            localLightFaceFeature.emotion = ((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).str_emotion.get();
          }
          Object localObject2;
          if (((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).image_size.has())
          {
            localObject2 = (Avatar2DLightAIData.Size)((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).image_size.get();
            localLightFaceFeature.imageSize[0] = ((Avatar2DLightAIData.Size)localObject2).width.get();
            localLightFaceFeature.imageSize[1] = ((Avatar2DLightAIData.Size)localObject2).height.get();
          }
          if (((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).float_yaw.has()) {
            localLightFaceFeature.yaw = ((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).float_yaw.get();
          }
          if (((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).float_roll.has()) {
            localLightFaceFeature.roll = ((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).float_roll.get();
          }
          if (((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).float_pitch.has()) {
            localLightFaceFeature.pitch = ((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).float_pitch.get();
          }
          Object localObject3;
          if (((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).re_bounds.has())
          {
            localObject3 = (Avatar2DLightAIData.Rect)((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).re_bounds.get();
            localObject2 = (Avatar2DLightAIData.Size)((Avatar2DLightAIData.Rect)localObject3).size.get();
            localObject3 = (Avatar2DLightAIData.Point)((Avatar2DLightAIData.Rect)localObject3).point.get();
            localLightFaceFeature.reBounds[0] = ((Avatar2DLightAIData.Point)localObject3).x.get();
            localLightFaceFeature.reBounds[1] = ((Avatar2DLightAIData.Point)localObject3).y.get();
            localLightFaceFeature.reBounds[2] = ((Avatar2DLightAIData.Size)localObject2).width.get();
            localLightFaceFeature.reBounds[3] = ((Avatar2DLightAIData.Size)localObject2).height.get();
          }
          if (((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).mouth_bounds.has())
          {
            localObject3 = (Avatar2DLightAIData.Rect)((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).mouth_bounds.get();
            localObject2 = (Avatar2DLightAIData.Size)((Avatar2DLightAIData.Rect)localObject3).size.get();
            localObject3 = (Avatar2DLightAIData.Point)((Avatar2DLightAIData.Rect)localObject3).point.get();
            localLightFaceFeature.mouthBounds[0] = ((Avatar2DLightAIData.Point)localObject3).x.get();
            localLightFaceFeature.mouthBounds[1] = ((Avatar2DLightAIData.Point)localObject3).y.get();
            localLightFaceFeature.mouthBounds[2] = ((Avatar2DLightAIData.Size)localObject2).width.get();
            localLightFaceFeature.mouthBounds[3] = ((Avatar2DLightAIData.Size)localObject2).height.get();
          }
          if (((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).le_bounds.has())
          {
            localObject3 = (Avatar2DLightAIData.Rect)((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).le_bounds.get();
            localObject2 = (Avatar2DLightAIData.Size)((Avatar2DLightAIData.Rect)localObject3).size.get();
            localObject3 = (Avatar2DLightAIData.Point)((Avatar2DLightAIData.Rect)localObject3).point.get();
            localLightFaceFeature.leBounds[0] = ((Avatar2DLightAIData.Point)localObject3).x.get();
            localLightFaceFeature.leBounds[1] = ((Avatar2DLightAIData.Point)localObject3).y.get();
            localLightFaceFeature.leBounds[2] = ((Avatar2DLightAIData.Size)localObject2).width.get();
            localLightFaceFeature.leBounds[3] = ((Avatar2DLightAIData.Size)localObject2).height.get();
          }
          if (((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).face_bounds.has())
          {
            localObject3 = (Avatar2DLightAIData.Rect)((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).face_bounds.get();
            localObject2 = (Avatar2DLightAIData.Size)((Avatar2DLightAIData.Rect)localObject3).size.get();
            localObject3 = (Avatar2DLightAIData.Point)((Avatar2DLightAIData.Rect)localObject3).point.get();
            localLightFaceFeature.faceBoundsRect[0] = ((Avatar2DLightAIData.Point)localObject3).x.get();
            localLightFaceFeature.faceBoundsRect[1] = ((Avatar2DLightAIData.Point)localObject3).y.get();
            localLightFaceFeature.faceBoundsRect[2] = ((Avatar2DLightAIData.Size)localObject2).width.get();
            localLightFaceFeature.faceBoundsRect[3] = ((Avatar2DLightAIData.Size)localObject2).height.get();
          }
          if (((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).expression.has())
          {
            localObject3 = ((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).expression.get();
            localObject2 = new HashMap();
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              Avatar2DLightAIData.AIExpression localAIExpression = (Avatar2DLightAIData.AIExpression)((Iterator)localObject3).next();
              ((HashMap)localObject2).put(localAIExpression.str_key.get(), Boolean.valueOf(localAIExpression.bool_value.get()));
            }
            localLightFaceFeature.expression_status_ = ((HashMap)localObject2);
          }
          int i;
          if (((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).float_face_points83.has())
          {
            localObject2 = ((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).float_face_points83.get();
            i = 0;
            while ((i < ((List)localObject2).size()) && (i < localLightFaceFeature.facePoint83.length))
            {
              localLightFaceFeature.facePoint83[i] = ((Float)((List)localObject2).get(i)).floatValue();
              i += 1;
            }
          }
          if (((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).float_face_points83_vis.has())
          {
            localObject1 = ((Avatar2DLightAIData.AvatarAIFaceFeature)localObject1).float_face_points83_vis.get();
            i = 0;
            while ((i < ((List)localObject1).size()) && (i < localLightFaceFeature.facePoint83Visibility.length))
            {
              localLightFaceFeature.facePoint83Visibility[i] = ((Float)((List)localObject1).get(i)).floatValue();
              i += 1;
            }
          }
          localArrayList2.add(localLightFaceFeature);
        }
        localLightFaceData.mLightFaceFeatureList = localArrayList2;
      }
      if (paramAvatar2DAIData.detect_image_size.has())
      {
        paramAvatar2DAIData = (Avatar2DLightAIData.Size)paramAvatar2DAIData.detect_image_size.get();
        localLightFaceData.imageSize[0] = ((int)paramAvatar2DAIData.width.get());
        localLightFaceData.imageSize[1] = ((int)paramAvatar2DAIData.height.get());
      }
    }
    return new LightAIData(localLightFaceData, localArrayList1, new ArrayList(), null, 4);
  }
  
  private static Avatar2DLightAIData.Avatar2DAIData a(LightAIData paramLightAIData)
  {
    ArrayList localArrayList = null;
    if (paramLightAIData == null) {
      return null;
    }
    Object localObject1 = (LightFaceData)paramLightAIData.getAiResult();
    Avatar2DLightAIData.Avatar2DAIData localAvatar2DAIData = new Avatar2DLightAIData.Avatar2DAIData();
    localAvatar2DAIData.str_key.set("FACE_AGENT");
    if (localObject1 != null)
    {
      Avatar2DLightAIData.AvatarAIFaceData localAvatarAIFaceData = new Avatar2DLightAIData.AvatarAIFaceData();
      paramLightAIData = localArrayList;
      if (((LightFaceData)localObject1).imageSize != null)
      {
        paramLightAIData = new Avatar2DLightAIData.Size();
        paramLightAIData.width.set(localObject1.imageSize[0]);
        paramLightAIData.height.set(localObject1.imageSize[1]);
        localAvatarAIFaceData.detect_image_size.set(paramLightAIData);
      }
      if ((((LightFaceData)localObject1).mLightFaceFeatureList != null) && (((LightFaceData)localObject1).mLightFaceFeatureList.size() > 0))
      {
        localArrayList = new ArrayList();
        localObject1 = ((LightFaceData)localObject1).mLightFaceFeatureList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (LightFaceFeature)((Iterator)localObject1).next();
          Avatar2DLightAIData.AvatarAIFaceFeature localAvatarAIFaceFeature = new Avatar2DLightAIData.AvatarAIFaceFeature();
          localAvatarAIFaceFeature.bool_has_outline.set(((LightFaceFeature)localObject2).hasOutline);
          localAvatarAIFaceFeature.float_pitch.set(((LightFaceFeature)localObject2).pitch);
          localAvatarAIFaceFeature.float_roll.set(((LightFaceFeature)localObject2).roll);
          localAvatarAIFaceFeature.float_yaw.set(((LightFaceFeature)localObject2).yaw);
          if (paramLightAIData != null) {
            localAvatarAIFaceFeature.image_size.set(paramLightAIData);
          }
          Object localObject3;
          Object localObject4;
          if (((LightFaceFeature)localObject2).leBounds != null)
          {
            localObject3 = new Avatar2DLightAIData.Rect();
            localObject4 = new Avatar2DLightAIData.Point();
            ((Avatar2DLightAIData.Point)localObject4).x.set(localObject2.leBounds[0]);
            ((Avatar2DLightAIData.Point)localObject4).y.set(localObject2.leBounds[1]);
            ((Avatar2DLightAIData.Rect)localObject3).point.set((MessageMicro)localObject4);
            localObject4 = new Avatar2DLightAIData.Size();
            ((Avatar2DLightAIData.Size)localObject4).width.set(localObject2.leBounds[2]);
            ((Avatar2DLightAIData.Size)localObject4).height.set(localObject2.leBounds[3]);
            ((Avatar2DLightAIData.Rect)localObject3).size.set((MessageMicro)localObject4);
            localAvatarAIFaceFeature.le_bounds.set((MessageMicro)localObject3);
          }
          if (((LightFaceFeature)localObject2).mouthBounds != null)
          {
            localObject3 = new Avatar2DLightAIData.Rect();
            localObject4 = new Avatar2DLightAIData.Point();
            ((Avatar2DLightAIData.Point)localObject4).x.set(localObject2.mouthBounds[0]);
            ((Avatar2DLightAIData.Point)localObject4).y.set(localObject2.mouthBounds[1]);
            ((Avatar2DLightAIData.Rect)localObject3).point.set((MessageMicro)localObject4);
            localObject4 = new Avatar2DLightAIData.Size();
            ((Avatar2DLightAIData.Size)localObject4).width.set(localObject2.mouthBounds[2]);
            ((Avatar2DLightAIData.Size)localObject4).height.set(localObject2.mouthBounds[3]);
            ((Avatar2DLightAIData.Rect)localObject3).size.set((MessageMicro)localObject4);
            localAvatarAIFaceFeature.mouth_bounds.set((MessageMicro)localObject3);
          }
          if (((LightFaceFeature)localObject2).reBounds != null)
          {
            localObject3 = new Avatar2DLightAIData.Rect();
            localObject4 = new Avatar2DLightAIData.Point();
            ((Avatar2DLightAIData.Point)localObject4).x.set(localObject2.reBounds[0]);
            ((Avatar2DLightAIData.Point)localObject4).y.set(localObject2.reBounds[1]);
            ((Avatar2DLightAIData.Rect)localObject3).point.set((MessageMicro)localObject4);
            localObject4 = new Avatar2DLightAIData.Size();
            ((Avatar2DLightAIData.Size)localObject4).width.set(localObject2.reBounds[2]);
            ((Avatar2DLightAIData.Size)localObject4).height.set(localObject2.reBounds[3]);
            ((Avatar2DLightAIData.Rect)localObject3).size.set((MessageMicro)localObject4);
            localAvatarAIFaceFeature.re_bounds.set((MessageMicro)localObject3);
          }
          if (((LightFaceFeature)localObject2).faceBoundsRect != null)
          {
            localObject3 = new Avatar2DLightAIData.Rect();
            localObject4 = new Avatar2DLightAIData.Point();
            ((Avatar2DLightAIData.Point)localObject4).x.set(localObject2.faceBoundsRect[0]);
            ((Avatar2DLightAIData.Point)localObject4).y.set(localObject2.faceBoundsRect[1]);
            ((Avatar2DLightAIData.Rect)localObject3).point.set((MessageMicro)localObject4);
            localObject4 = new Avatar2DLightAIData.Size();
            ((Avatar2DLightAIData.Size)localObject4).width.set(localObject2.faceBoundsRect[2]);
            ((Avatar2DLightAIData.Size)localObject4).height.set(localObject2.faceBoundsRect[3]);
            ((Avatar2DLightAIData.Rect)localObject3).size.set((MessageMicro)localObject4);
            localAvatarAIFaceFeature.face_bounds.set((MessageMicro)localObject3);
          }
          if (((LightFaceFeature)localObject2).emotion != null) {
            localAvatarAIFaceFeature.str_emotion.set(((LightFaceFeature)localObject2).emotion);
          }
          if (((LightFaceFeature)localObject2).gender != null) {
            localAvatarAIFaceFeature.str_gender.set(((LightFaceFeature)localObject2).gender);
          }
          int j;
          int i;
          if ((((LightFaceFeature)localObject2).facePoint83Visibility != null) && (((LightFaceFeature)localObject2).facePoint83Visibility.length > 0))
          {
            localObject3 = new ArrayList();
            localObject4 = ((LightFaceFeature)localObject2).facePoint83Visibility;
            j = localObject4.length;
            i = 0;
            while (i < j)
            {
              ((List)localObject3).add(Float.valueOf(localObject4[i]));
              i += 1;
            }
            localAvatarAIFaceFeature.float_face_points83_vis.set((List)localObject3);
          }
          if ((((LightFaceFeature)localObject2).facePoint83 != null) && (((LightFaceFeature)localObject2).facePoint83.length > 0))
          {
            localObject3 = new ArrayList();
            localObject4 = ((LightFaceFeature)localObject2).facePoint83;
            j = localObject4.length;
            i = 0;
            while (i < j)
            {
              ((List)localObject3).add(Float.valueOf(localObject4[i]));
              i += 1;
            }
            localAvatarAIFaceFeature.float_face_points83.set((List)localObject3);
          }
          if ((((LightFaceFeature)localObject2).expression_status_ != null) && (((LightFaceFeature)localObject2).expression_status_.size() > 0))
          {
            localObject3 = new ArrayList();
            localObject2 = ((LightFaceFeature)localObject2).expression_status_.entrySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = (Map.Entry)((Iterator)localObject2).next();
              Avatar2DLightAIData.AIExpression localAIExpression = new Avatar2DLightAIData.AIExpression();
              localAIExpression.bool_value.set(((Boolean)((Map.Entry)localObject4).getValue()).booleanValue());
              localAIExpression.str_key.set((String)((Map.Entry)localObject4).getKey());
              ((List)localObject3).add(localAIExpression);
            }
            localAvatarAIFaceFeature.expression.set((List)localObject3);
          }
          localArrayList.add(localAvatarAIFaceFeature);
        }
        localAvatarAIFaceData.face_feature.set(localArrayList);
      }
      localAvatar2DAIData.ai_face_data.set(localAvatarAIFaceData);
    }
    return localAvatar2DAIData;
  }
  
  private static Avatar2DLightAIData.Avatar2DAIData a(LightAIData paramLightAIData, String paramString)
  {
    if (paramLightAIData == null) {
      return null;
    }
    Avatar2DLightAIData.Avatar2DAIData localAvatar2DAIData = new Avatar2DLightAIData.Avatar2DAIData();
    localAvatar2DAIData.str_key.set(paramString);
    paramString = paramLightAIData.getAiKeyPoints();
    if ((paramString != null) && (paramString.size() > 0)) {
      localAvatar2DAIData.keypoints.set(a(paramString));
    }
    paramString = paramLightAIData.getAiClassifiers();
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramLightAIData = new ArrayList();
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        LightAIClassifier localLightAIClassifier = (LightAIClassifier)paramString.next();
        Avatar2DLightAIData.AIClassifier localAIClassifier = new Avatar2DLightAIData.AIClassifier();
        localAIClassifier.uint32_trace_id.set(localLightAIClassifier.getTraceId());
        localAIClassifier.str_classifier.set(localLightAIClassifier.getClassifiers());
        paramLightAIData.add(localAIClassifier);
      }
      localAvatar2DAIData.classifiers.set(paramLightAIData);
    }
    return localAvatar2DAIData;
  }
  
  public static void a(PeerAvatar2DAIDataHandler paramPeerAvatar2DAIDataHandler, byte[] paramArrayOfByte)
  {
    Object localObject = new Avatar2DLightAIData.Avatar2DAIDataWrapper();
    LightAIDataWrapper localLightAIDataWrapper = new LightAIDataWrapper();
    try
    {
      ((Avatar2DLightAIData.Avatar2DAIDataWrapper)localObject).mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    if ((((Avatar2DLightAIData.Avatar2DAIDataWrapper)localObject).material_id.has()) && (paramPeerAvatar2DAIDataHandler != null)) {
      paramPeerAvatar2DAIDataHandler.a(((Avatar2DLightAIData.Avatar2DAIDataWrapper)localObject).material_id.get());
    }
    if ((((Avatar2DLightAIData.Avatar2DAIDataWrapper)localObject).background_id.has()) && (paramPeerAvatar2DAIDataHandler != null)) {
      paramPeerAvatar2DAIDataHandler.b(((Avatar2DLightAIData.Avatar2DAIDataWrapper)localObject).background_id.get());
    }
    if (((Avatar2DLightAIData.Avatar2DAIDataWrapper)localObject).wrapper_data_map.has())
    {
      paramArrayOfByte = ((Avatar2DLightAIData.Avatar2DAIDataWrapper)localObject).wrapper_data_map.get().iterator();
      while (paramArrayOfByte.hasNext())
      {
        localObject = (Avatar2DLightAIData.Avatar2DAIDataMap)paramArrayOfByte.next();
        if (((Avatar2DLightAIData.Avatar2DAIDataMap)localObject).ai_data.has()) {
          if (((Avatar2DLightAIData.Avatar2DAIDataMap)localObject).str_key.get().equals("FACE_AGENT")) {
            localLightAIDataWrapper.setAIData("FACE_AGENT", a((Avatar2DLightAIData.Avatar2DAIData)((Avatar2DLightAIData.Avatar2DAIDataMap)localObject).ai_data.get()));
          } else if (((Avatar2DLightAIData.Avatar2DAIDataMap)localObject).str_key.get().equals("k3D_MM_AGENT")) {
            localLightAIDataWrapper.setAIData("k3D_MM_AGENT", b((Avatar2DLightAIData.Avatar2DAIData)((Avatar2DLightAIData.Avatar2DAIDataMap)localObject).ai_data.get()));
          } else {
            a(localLightAIDataWrapper, (Avatar2DLightAIData.Avatar2DAIDataMap)localObject);
          }
        }
      }
    }
    if (paramPeerAvatar2DAIDataHandler != null) {
      paramPeerAvatar2DAIDataHandler.a(localLightAIDataWrapper);
    }
  }
  
  private static void a(LightAIDataWrapper paramLightAIDataWrapper, Avatar2DLightAIData.Avatar2DAIDataMap paramAvatar2DAIDataMap)
  {
    if (!paramAvatar2DAIDataMap.ai_data.has()) {
      return;
    }
    int i = 0;
    while (i < a.length)
    {
      if (paramAvatar2DAIDataMap.str_key.get().equals(a[i])) {
        paramLightAIDataWrapper.setAIData(a[i], c((Avatar2DLightAIData.Avatar2DAIData)paramAvatar2DAIDataMap.ai_data.get()));
      }
      i += 1;
    }
  }
  
  public static byte[] a(AEFilterAVWrapper paramAEFilterAVWrapper, String paramString1, String paramString2)
  {
    Avatar2DLightAIData.Avatar2DAIDataWrapper localAvatar2DAIDataWrapper = new Avatar2DLightAIData.Avatar2DAIDataWrapper();
    if (paramString1 != null) {
      localAvatar2DAIDataWrapper.material_id.set(paramString1);
    }
    Object localObject = localAvatar2DAIDataWrapper.background_id;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((PBStringField)localObject).set(paramString1);
    paramString1 = new ArrayList();
    localObject = paramAEFilterAVWrapper.b("FACE_AGENT");
    if (localObject != null)
    {
      paramString2 = new Avatar2DLightAIData.Avatar2DAIDataMap();
      paramString2.str_key.set("FACE_AGENT");
      localObject = a((LightAIData)localObject);
      if (localObject != null)
      {
        paramString2.ai_data.set((MessageMicro)localObject);
        paramString1.add(paramString2);
      }
    }
    localObject = paramAEFilterAVWrapper.b("k3D_MM_AGENT");
    if (localObject != null)
    {
      paramString2 = new Avatar2DLightAIData.Avatar2DAIDataMap();
      paramString2.str_key.set("k3D_MM_AGENT");
      localObject = b((LightAIData)localObject);
      if (localObject != null)
      {
        paramString2.ai_data.set((MessageMicro)localObject);
        paramString1.add(paramString2);
      }
    }
    int i = 0;
    for (;;)
    {
      paramString2 = a;
      if (i >= paramString2.length) {
        break;
      }
      localObject = paramAEFilterAVWrapper.b(paramString2[i]);
      if ((localObject != null) && ((((LightAIData)localObject).getAiClassifiers() != null) || (((LightAIData)localObject).getAiKeyPoints() != null)))
      {
        paramString2 = new Avatar2DLightAIData.Avatar2DAIDataMap();
        paramString2.str_key.set(a[i]);
        localObject = a((LightAIData)localObject, a[i]);
        if (localObject != null)
        {
          paramString2.ai_data.set((MessageMicro)localObject);
          paramString1.add(paramString2);
        }
      }
      i += 1;
    }
    localAvatar2DAIDataWrapper.wrapper_data_map.set(paramString1);
    return localAvatar2DAIDataWrapper.toByteArray();
  }
  
  private static List<LightAIKeyPoint> b(List<Avatar2DLightAIData.AIKeyPoint> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Avatar2DLightAIData.AIKeyPoint localAIKeyPoint = (Avatar2DLightAIData.AIKeyPoint)localIterator.next();
      paramList = null;
      if (localAIKeyPoint.float_keypoint.has())
      {
        List localList = localAIKeyPoint.float_keypoint.get();
        paramList = new float[localList.size()];
        int i = 0;
        while (i < localList.size())
        {
          paramList[i] = ((Float)localList.get(i)).floatValue();
          i += 1;
        }
      }
      localArrayList.add(new LightAIKeyPoint(localAIKeyPoint.uint32_trace_id.get(), paramList));
    }
    return localArrayList;
  }
  
  private static LightAIData b(Avatar2DLightAIData.Avatar2DAIData paramAvatar2DAIData)
  {
    Object localObject1 = new ArrayList();
    if (paramAvatar2DAIData.keypoints.has()) {
      localObject1 = b(paramAvatar2DAIData.keypoints.get());
    }
    ArrayList localArrayList = new ArrayList();
    if (paramAvatar2DAIData.ai_3dmm_data.has())
    {
      paramAvatar2DAIData = (Avatar2DLightAIData.AvatarAI3DMMData)paramAvatar2DAIData.ai_3dmm_data.get();
      paramAvatar2DAIData.detect_image_size.has();
      if (paramAvatar2DAIData.result_expression.has())
      {
        Iterator localIterator = paramAvatar2DAIData.result_expression.get().iterator();
        while (localIterator.hasNext())
        {
          Object localObject4 = (Avatar2DLightAIData.AvatarAI3DMMFeature)localIterator.next();
          paramAvatar2DAIData = (float[][])null;
          PointF localPointF = new PointF();
          int i;
          if (((Avatar2DLightAIData.AvatarAI3DMMFeature)localObject4).uint32_trace_id.has()) {
            i = ((Avatar2DLightAIData.AvatarAI3DMMFeature)localObject4).uint32_trace_id.get();
          } else {
            i = 0;
          }
          float f1;
          if (((Avatar2DLightAIData.AvatarAI3DMMFeature)localObject4).float_scale.has()) {
            f1 = ((Avatar2DLightAIData.AvatarAI3DMMFeature)localObject4).float_scale.get();
          } else {
            f1 = 0.0F;
          }
          float f2;
          if (((Avatar2DLightAIData.AvatarAI3DMMFeature)localObject4).float_point_scale.has()) {
            f2 = ((Avatar2DLightAIData.AvatarAI3DMMFeature)localObject4).float_point_scale.get();
          } else {
            f2 = 0.0F;
          }
          boolean bool;
          if (((Avatar2DLightAIData.AvatarAI3DMMFeature)localObject4).bool_is_kissing.has()) {
            bool = ((Avatar2DLightAIData.AvatarAI3DMMFeature)localObject4).bool_is_kissing.get();
          } else {
            bool = false;
          }
          Object localObject2;
          float[] arrayOfFloat;
          int j;
          if (((Avatar2DLightAIData.AvatarAI3DMMFeature)localObject4).float_exp.has())
          {
            localObject2 = ((Avatar2DLightAIData.AvatarAI3DMMFeature)localObject4).float_exp.get();
            arrayOfFloat = new float[((List)localObject2).size()];
            j = 0;
            while (j < ((List)localObject2).size())
            {
              arrayOfFloat[j] = ((Float)((List)localObject2).get(j)).floatValue();
              j += 1;
            }
          }
          else
          {
            arrayOfFloat = null;
          }
          Object localObject3;
          if (((Avatar2DLightAIData.AvatarAI3DMMFeature)localObject4).float_euler.has())
          {
            localObject3 = ((Avatar2DLightAIData.AvatarAI3DMMFeature)localObject4).float_euler.get();
            localObject2 = new float[((List)localObject3).size()];
            j = 0;
            while (j < ((List)localObject3).size())
            {
              localObject2[j] = ((Float)((List)localObject3).get(j)).floatValue();
              j += 1;
            }
          }
          else
          {
            localObject2 = null;
          }
          if (((Avatar2DLightAIData.AvatarAI3DMMFeature)localObject4).translate.has())
          {
            localObject3 = (Avatar2DLightAIData.Point)((Avatar2DLightAIData.AvatarAI3DMMFeature)localObject4).translate.get();
            localPointF.x = ((Avatar2DLightAIData.Point)localObject3).x.get();
            localPointF.y = ((Avatar2DLightAIData.Point)localObject3).y.get();
          }
          List localList;
          if (((Avatar2DLightAIData.AvatarAI3DMMFeature)localObject4).trans_matrix.has())
          {
            localList = ((Avatar2DLightAIData.AvatarAI3DMMFeature)localObject4).trans_matrix.get();
            localObject3 = (float[][])Array.newInstance(Float.TYPE, new int[] { localList.size(), 4 });
            j = 0;
            while (j < localList.size())
            {
              Avatar2DLightAIData.Matrix4 localMatrix4 = (Avatar2DLightAIData.Matrix4)localList.get(j);
              localObject3[j][0] = localMatrix4.m1.get();
              localObject3[j][1] = localMatrix4.m2.get();
              localObject3[j][2] = localMatrix4.m3.get();
              localObject3[j][3] = localMatrix4.m4.get();
              j += 1;
            }
          }
          else
          {
            localObject3 = paramAvatar2DAIData;
          }
          if (((Avatar2DLightAIData.AvatarAI3DMMFeature)localObject4).transform.has())
          {
            localList = ((Avatar2DLightAIData.AvatarAI3DMMFeature)localObject4).transform.get();
            localObject4 = (float[][])Array.newInstance(Float.TYPE, new int[] { localList.size(), 4 });
            j = 0;
            for (;;)
            {
              paramAvatar2DAIData = (Avatar2DLightAIData.Avatar2DAIData)localObject4;
              if (j >= localList.size()) {
                break;
              }
              paramAvatar2DAIData = (Avatar2DLightAIData.Matrix4)localList.get(j);
              localObject4[j][0] = paramAvatar2DAIData.m1.get();
              localObject4[j][1] = paramAvatar2DAIData.m2.get();
              localObject4[j][2] = paramAvatar2DAIData.m3.get();
              localObject4[j][3] = paramAvatar2DAIData.m4.get();
              j += 1;
            }
          }
          localArrayList.add(new Light3DMMFeature((float[][])localObject3, paramAvatar2DAIData, (float[])localObject2, arrayOfFloat, localPointF, 0, null, null, i, f2, f1, bool));
        }
      }
    }
    return new LightAIData(new Light3DMMData(localArrayList), (List)localObject1, new ArrayList(), null, 4);
  }
  
  private static Avatar2DLightAIData.Avatar2DAIData b(LightAIData paramLightAIData)
  {
    if (paramLightAIData == null) {
      return null;
    }
    Avatar2DLightAIData.Avatar2DAIData localAvatar2DAIData = new Avatar2DLightAIData.Avatar2DAIData();
    localAvatar2DAIData.str_key.set("k3D_MM_AGENT");
    Object localObject1 = paramLightAIData.getAiKeyPoints();
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      localAvatar2DAIData.keypoints.set(a((List)localObject1));
    }
    Object localObject2 = (Light3DMMData)paramLightAIData.getAiResult();
    if (((Light3DMMData)localObject2).getLight3dmmFeatures() != null)
    {
      paramLightAIData = new Avatar2DLightAIData.AvatarAI3DMMData();
      localObject1 = new ArrayList();
      localObject2 = ((Light3DMMData)localObject2).getLight3dmmFeatures().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Light3DMMFeature localLight3DMMFeature = (Light3DMMFeature)((Iterator)localObject2).next();
        Avatar2DLightAIData.AvatarAI3DMMFeature localAvatarAI3DMMFeature = new Avatar2DLightAIData.AvatarAI3DMMFeature();
        localAvatarAI3DMMFeature.bool_is_kissing.set(localLight3DMMFeature.is_kissing);
        localAvatarAI3DMMFeature.float_point_scale.set(localLight3DMMFeature.point_scale);
        localAvatarAI3DMMFeature.float_scale.set(localLight3DMMFeature.scale);
        localAvatarAI3DMMFeature.uint32_trace_id.set(localLight3DMMFeature.trace_id);
        Object localObject3;
        Object localObject4;
        int j;
        int i;
        if ((localLight3DMMFeature.euler != null) && (localLight3DMMFeature.euler.length > 0))
        {
          localObject3 = new ArrayList();
          localObject4 = localLight3DMMFeature.euler;
          j = localObject4.length;
          i = 0;
          while (i < j)
          {
            ((List)localObject3).add(Float.valueOf(localObject4[i]));
            i += 1;
          }
          localAvatarAI3DMMFeature.float_euler.set((List)localObject3);
        }
        if ((localLight3DMMFeature.exp != null) && (localLight3DMMFeature.exp.length > 0))
        {
          localObject3 = new ArrayList();
          localObject4 = localLight3DMMFeature.exp;
          j = localObject4.length;
          i = 0;
          while (i < j)
          {
            ((List)localObject3).add(Float.valueOf(localObject4[i]));
            i += 1;
          }
          localAvatarAI3DMMFeature.float_exp.set((List)localObject3);
        }
        Object localObject5;
        Avatar2DLightAIData.Matrix4 localMatrix4;
        if ((localLight3DMMFeature.trans_matrix != null) && (localLight3DMMFeature.trans_matrix.length > 0))
        {
          localObject3 = new ArrayList();
          localObject4 = localLight3DMMFeature.trans_matrix;
          j = localObject4.length;
          i = 0;
          while (i < j)
          {
            localObject5 = localObject4[i];
            if (localObject5 != null)
            {
              localMatrix4 = new Avatar2DLightAIData.Matrix4();
              localMatrix4.m1.set(localObject5[0]);
              localMatrix4.m2.set(localObject5[1]);
              localMatrix4.m3.set(localObject5[2]);
              localMatrix4.m4.set(localObject5[3]);
              ((List)localObject3).add(localMatrix4);
            }
            i += 1;
          }
          localAvatarAI3DMMFeature.trans_matrix.set((List)localObject3);
        }
        if ((localLight3DMMFeature.transform != null) && (localLight3DMMFeature.transform.length > 0))
        {
          localObject3 = new ArrayList();
          localObject4 = localLight3DMMFeature.transform;
          j = localObject4.length;
          i = 0;
          while (i < j)
          {
            localObject5 = localObject4[i];
            if (localObject5 != null)
            {
              localMatrix4 = new Avatar2DLightAIData.Matrix4();
              localMatrix4.m1.set(localObject5[0]);
              localMatrix4.m2.set(localObject5[1]);
              localMatrix4.m3.set(localObject5[2]);
              localMatrix4.m4.set(localObject5[3]);
              ((List)localObject3).add(localMatrix4);
            }
            i += 1;
          }
          localAvatarAI3DMMFeature.transform.set((List)localObject3);
        }
        if (localLight3DMMFeature.translate != null)
        {
          localObject3 = new Avatar2DLightAIData.Point();
          ((Avatar2DLightAIData.Point)localObject3).x.set(localLight3DMMFeature.translate.x);
          ((Avatar2DLightAIData.Point)localObject3).y.set(localLight3DMMFeature.translate.y);
          localAvatarAI3DMMFeature.translate.set((MessageMicro)localObject3);
        }
        ((List)localObject1).add(localAvatarAI3DMMFeature);
      }
      localObject2 = new Avatar2DLightAIData.Size();
      ((Avatar2DLightAIData.Size)localObject2).width.set(0.0F);
      ((Avatar2DLightAIData.Size)localObject2).height.set(0.0F);
      paramLightAIData.detect_image_size.set((MessageMicro)localObject2);
      paramLightAIData.result_expression.set((List)localObject1);
      localAvatar2DAIData.ai_3dmm_data.set(paramLightAIData);
    }
    return localAvatar2DAIData;
  }
  
  private static LightAIData c(Avatar2DLightAIData.Avatar2DAIData paramAvatar2DAIData)
  {
    Object localObject = new ArrayList();
    if (paramAvatar2DAIData.keypoints.has()) {
      localObject = b(paramAvatar2DAIData.keypoints.get());
    }
    ArrayList localArrayList = new ArrayList();
    if (paramAvatar2DAIData.classifiers.has())
    {
      paramAvatar2DAIData = paramAvatar2DAIData.classifiers.get().iterator();
      while (paramAvatar2DAIData.hasNext())
      {
        Avatar2DLightAIData.AIClassifier localAIClassifier = (Avatar2DLightAIData.AIClassifier)paramAvatar2DAIData.next();
        localArrayList.add(new LightAIClassifier(localAIClassifier.uint32_trace_id.get(), localAIClassifier.str_classifier.get()));
      }
    }
    return new LightAIData(null, (List)localObject, localArrayList, null, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.Avatar2DAIDataTransformer
 * JD-Core Version:    0.7.0.1
 */