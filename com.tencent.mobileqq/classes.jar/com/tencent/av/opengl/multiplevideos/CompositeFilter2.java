package com.tencent.av.opengl.multiplevideos;

import com.tencent.av.opengl.multiplevideos.renderbase.Filter;

public class CompositeFilter2
  extends Filter
{
  private static String a = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
  private static String b = "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform vec4 offset;\nuniform vec4 offset1;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture1;\nvoid main() {\n    vec2 newCoordinate;\n    if (textureCoordinate.x <= 0.5) {\n        newCoordinate.x = offset.x + textureCoordinate.x * 2.0 * (1.0 - offset.y - offset.x);\n        newCoordinate.y = offset.y + textureCoordinate.y * (1.0 - offset.w - offset.z);\n        gl_FragColor = texture2D(inputImageTexture, newCoordinate);\n    } else {\n        newCoordinate.x = offset1.x + (textureCoordinate.x - 0.5) * 2.0 * (1.0 - offset1.y - offset1.x);\n        newCoordinate.y = offset1.z + textureCoordinate.y * (1.0 - offset1.w - offset1.z);\n        gl_FragColor = texture2D(inputImageTexture1, newCoordinate);\n    }\n}";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.multiplevideos.CompositeFilter2
 * JD-Core Version:    0.7.0.1
 */