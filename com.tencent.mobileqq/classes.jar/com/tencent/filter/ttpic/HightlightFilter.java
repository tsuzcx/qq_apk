package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;

public class HightlightFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER1 = "precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n\n float nextLevelGrayMin = 0.0;\n float nextLevelGrayMax = 128.0 / 255.0;\n\n void main()\n {\n   vec4 originColor = texture2D(inputImageTexture, textureCoordinate);\n   \n   //levelGrayMix\n   float originGray = 0.114 * originColor.b + 0.587 * originColor.g + 0.299 * originColor.r;\n   float alpha = originColor.a;\n    \n   if (originGray < nextLevelGrayMax) {\n       alpha = 0.0;\n//       gl_FragColor = vec4(1.0, 1.0, 1.0, 0.0);\n       gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0);\n   } else {\n       gl_FragColor = vec4(originColor.r, originColor.g, originColor.b, originColor.a);\n   }\n    \n//    gl_FragColor = vec4(1.0, 1.0, 1.0, 1.0);\n   \n//   gl_FragColor = vec4(originColor.r, originColor.g, originColor.b, alpha);\n }";
  
  public HightlightFilter()
  {
    this(null);
  }
  
  public HightlightFilter(String paramString)
  {
    super("precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n\n float nextLevelGrayMin = 0.0;\n float nextLevelGrayMax = 128.0 / 255.0;\n\n void main()\n {\n   vec4 originColor = texture2D(inputImageTexture, textureCoordinate);\n   \n   //levelGrayMix\n   float originGray = 0.114 * originColor.b + 0.587 * originColor.g + 0.299 * originColor.r;\n   float alpha = originColor.a;\n    \n   if (originGray < nextLevelGrayMax) {\n       alpha = 0.0;\n//       gl_FragColor = vec4(1.0, 1.0, 1.0, 0.0);\n       gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0);\n   } else {\n       gl_FragColor = vec4(originColor.r, originColor.g, originColor.b, originColor.a);\n   }\n    \n//    gl_FragColor = vec4(1.0, 1.0, 1.0, 1.0);\n   \n//   gl_FragColor = vec4(originColor.r, originColor.g, originColor.b, alpha);\n }");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.filter.ttpic.HightlightFilter
 * JD-Core Version:    0.7.0.1
 */